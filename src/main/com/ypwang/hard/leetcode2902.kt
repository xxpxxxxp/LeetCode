package com.ypwang.hard

class Solution2902 {
    fun countSubMultisets(nums: List<Int>, l: Int, r: Int): Int {
        val dp = LongArray(20010)
        dp[0] = 1L
        val mod = 1000000007

        val count = nums.groupBy { it }.mapValues { it.value.size }.toMap()
        for ((num, freq) in count) {
            val pSum = dp.clone()
            for (i in 0..r)
                if (i >= num)
                    pSum[i] = (pSum[i] + pSum[i-num]) % mod

            for (i in r downTo 0) {
                if (num > 0) {
                    val j = i - (freq + 1) * num
                    dp[i] = pSum[i] - if (j >= 0) pSum[j] else 0
                    dp[i] = Math.floorMod(dp[i], mod.toLong())
                } else
                    dp[i] = (dp[i] * (freq + 1)) % mod
            }
        }

        return (l..r).fold(0L) { a, b -> (a + dp[b]) % mod }.toInt()
    }
}