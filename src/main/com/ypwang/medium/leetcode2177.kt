package com.ypwang.medium

class Solution2177 {
    fun sumOfThree(num: Long): LongArray {
        if (num % 3 != 0L)
            return longArrayOf()

        val n = num / 3
        return longArrayOf(n-1, n, n+1)
    }
}