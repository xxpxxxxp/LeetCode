package com.ypwang.hard

import java.util.*

class Solution4091 {
    fun countMagicalPairs(s: String): Long {
        val n = s.length
        val L = Array(n) { IntArray(27) }
        val R = Array(n) { IntArray(27) }
        val pos = IntArray(26) { -1 }

        for (i in 0 until n) {
            pos[s[i] - 'a'] = i
            val p = IntArray(26)
            var sz = 0
            for (x in pos)
                if (x != -1)
                    p[sz++] = x

            Arrays.sort(p, 0, sz)
            for (k in 0 until sz)
                L[i][k + 1] = p[sz - 1 - k] - (if (k + 1 < sz) p[sz - 2 - k] else -1)
        }

        Arrays.fill(pos, n)
        for (i in n - 1 downTo 0) {
            pos[s[i] - 'a'] = i
            val q = IntArray(26)
            var sz = 0
            for (x in pos)
                if (x != n)
                    q[sz++] = x
            Arrays.sort(q, 0, sz)
            for (k in 0 until sz)
                R[i][k + 1] = (if (k + 1 < sz) q[k + 1] else n) - q[k]
        }

        var res = 0L
        for (i in 0 until n - 1)
            for (k in 1..26)
                res += L[i][k].toLong() * R[i + 1][k]

        return res
    }
}
