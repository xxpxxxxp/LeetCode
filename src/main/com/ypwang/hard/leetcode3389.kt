package com.ypwang.hard

class Solution3389 {
    fun makeStringGood(s: String): Int {
        val n = s.length
        val f = IntArray(26)
        for (i in 0 until n)
            f[s[i] - 'a']++

        var ans = n
        for (m in 1..n) {
            var res = 0
            var dp1 = 0
            var dp2 = 0
            var free = 0
            for (i in 0 until 26) {
                val (ndp1, ndp2, nfree) = if (f[i] >= m) {
                    val ndp1 = minOf(dp1, dp2) + (f[i] - m)
                    val ndp2 = n
                    val nfree = f[i] - m
                    Triple(ndp1, ndp2, nfree)
                } else {
                    val ndp1 = minOf(dp1, dp2) + f[i]
                    val ndp2 = minOf(dp1 + maxOf(0, m - f[i] - free), dp2 + m - f[i])
                    val nfree = f[i]
                    Triple(ndp1, ndp2, nfree)
                }
                dp1 = ndp1
                dp2 = ndp2
                free = nfree
            }
            res = minOf(dp1, dp2)
            ans = minOf(ans, res)
        }
        return ans
    }
}
