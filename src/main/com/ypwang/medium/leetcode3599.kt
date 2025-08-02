package com.ypwang.medium

class Solution3599 {
    fun minXor(nums: IntArray, k: Int): Int {
        val n = nums.size

        // Step 1: Prefix XOR array
        val pfix = IntArray(n + 1)
        for (i in 1..n)
            pfix[i] = pfix[i - 1] xor nums[i - 1]

        // Step 2: DP table
        val dp = Array(n + 1) { IntArray(k + 1) {  Int.MAX_VALUE } }

        for (i in 0..n)
            dp[i][1] = pfix[i] // Base case: 1 partition

        // Step 3: Fill DP for partitions 2 to k
        for (parts in 2..k)
            for (end in parts..n)
                for (split in parts - 1..<end)
                    dp[end][parts] = minOf(dp[end][parts], maxOf(dp[split][parts - 1], pfix[end] xor pfix[split]))

        return dp[n][k]
    }
}
