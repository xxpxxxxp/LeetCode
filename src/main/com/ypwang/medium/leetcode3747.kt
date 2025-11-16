package com.ypwang.medium

class Solution3747 {
    fun countDistinct(n: Long): Long {
        val s = n.toString()
        val len = s.length
        var ans = 0L
        val p = LongArray(len + 1)
        for (i in 0..len)
            p[i] = 1
        for (i in 1..len)
            p[i] = p[i - 1] * 9
        for (l in 1 until len)
            ans += p[l]
        for (i in 0 until len) {
            val d = s[i] - '0'
            if (d == 0)
                return ans
            ans += (d - 1).toLong() * p[len - i - 1]
        }
        return ans + 1
    }
}
