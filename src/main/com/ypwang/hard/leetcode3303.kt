package com.ypwang.hard

class Solution3303 {
    private fun zFunction(s: String): IntArray {
        val n = s.length
        val z = IntArray(n)
        var l = 0
        var r = 0

        for (i in 1 until n) {
            if (i < r)
                z[i] = minOf(r - i, z[i - l])

            while (i + z[i] < n && s[z[i]] == s[i + z[i]])
                z[i]++

            if (i + z[i] > r) {
                l = i
                r = i + z[i]
            }
        }

        return z
    }

    fun minStartingIndex(s: String, pattern: String): Int {
        val a = "$pattern#$s"
        val n = s.length
        val m = pattern.length
        val b = ("$s#$pattern").reversed()

        val zForward = zFunction(a)
        val zBack = zFunction(b)

        for (i in m + 1 until n + m + 1) {
            if (i + m > n + m + 1)
                break

            val id = i - m - 1
            var x = zForward[i]

            if (x >= m - 1)
                return id

            x++
            val req = m - x
            val newId = id + m - 1
            val reversedId = n - 1 - newId
            val newIdReversed = m + 1 + reversedId

            if (zBack[newIdReversed] >= req)
                return id
        }

        return -1
    }
}
