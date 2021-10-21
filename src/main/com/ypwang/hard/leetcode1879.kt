package com.ypwang.hard

class Solution1879 {
    fun minimumXORSum(nums1: IntArray, nums2: IntArray): Int {
        val dp = IntArray(1 shl nums2.size){ Int.MAX_VALUE }

        fun dfs(i: Int, mask: Int): Int {
            if (i == nums1.size)
                return 0

            if (dp[mask] == Int.MAX_VALUE)
                dp[mask] =
                    nums2.indices
                        .filter { mask and (1 shl it) == 0 }
                        .map { (nums1[i] xor nums2[it]) + dfs(i + 1, mask or (1 shl it)) }
                        .minOrNull() ?: Int.MAX_VALUE

            return dp[mask]
        }

        return dfs(0, 0)
    }
}