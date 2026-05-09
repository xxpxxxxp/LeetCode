package com.ypwang.medium

class Solution3922 {
    fun minFlips(s: String): Int {
        val n = s.length
        if (n < 3)
            return 0

        var cnt0 = 0
        for (i in 0 until n)
            if (s[i] == '0')
                cnt0++

        val cnt1 = n - cnt0
        return minOf(cnt0, maxOf(cnt1 - 1, 0), cnt1 - (s[0] - '0') - (s[n-1] - '0'))
    }
}
