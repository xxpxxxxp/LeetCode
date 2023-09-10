package com.ypwang.medium

class Solution2844 {
    fun minimumOperations(num: String): Int {
        var ans = num.length
        val n = num.length
        for (i in n - 1 downTo 0) {
            for (j in i - 1 downTo 0) {
                val t = num[i] - '0' + (num[j] - '0') * 10
                if (t % 25 == 0)
                    ans = minOf(ans, n - j - 2)
            }
            if (num[i] == '0')
                ans = minOf(ans, n - 1)
        }
        return ans
    }
}