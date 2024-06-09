package com.ypwang.hard

class Solution3177 {
    fun maximumLength(nums: IntArray, k: Int): Int {
        val dp = Array(k + 1) { mutableMapOf<Int, Int>() }
        val res = IntArray(k + 1)
        for (a in nums) {
            for (i in k downTo 0) {
                val v = maxOf(dp[i].getOrDefault(a, 0) + 1, if (i > 0) res[i - 1] + 1 else 0)
                dp[i][a] = v
                res[i] = maxOf(res[i], v)
            }
        }
        return res[k]
    }
}
