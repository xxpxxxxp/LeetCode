package com.ypwang.medium

class Solution3685 {
    val MAX_K: Int = 4001
    fun subsequenceSumAfterCapping(nums: IntArray, k: Int): BooleanArray {
        val dp = BooleanArray(MAX_K)
        dp[0] = true
        // Sort nums so we can easily find how many elements are greater than x in O(1)
        nums.sort()
        val n = nums.size

        val ans = BooleanArray(n)

        var p = 0
        for (i in 1..n) {
            while (p < n && nums[p] < i) {
                for (j in k downTo nums[p])
                    dp[j] = dp[j] or dp[j - nums[p]]
                p++
            }

            val cnt = n - p

            // Multiple knapsacks
            for (j in 0..cnt) {
                // Pick j knapsacks (each has weight of i)
                val weight = i * j

                if (k < weight)
                    break

                // We can form dp[k - weight], so we can form dp[k]
                // by choosing j knapsacks (each has weight of i)
                if (dp[k - weight]) {
                    ans[i - 1] = true
                    break
                }
            }
        }

        return ans
    }
}
