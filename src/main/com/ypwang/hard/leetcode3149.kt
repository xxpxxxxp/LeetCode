package com.ypwang.hard

class Solution3149 {
    fun findPermutation(nums: IntArray): IntArray {
        val dp = Array(14) { IntArray(16384) }
        val track = Array(14) { IntArray(16384) }

        fun dfs(mask: Int, p: Int,): Int {
            if (Integer.bitCount(mask) == nums.size)
                return Math.abs(p - nums[0])

            if (dp[p][mask] == 0) {
                dp[p][mask] = Int.MAX_VALUE
                for (i in 1 until nums.size) {
                    if ((mask and (1 shl i)) == 0) {
                        val score = Math.abs(p - nums[i]) + dfs(mask or (1 shl i), i)
                        if (score < dp[p][mask]) {
                            dp[p][mask] = score
                            track[p][mask] = i
                        }
                    }
                }
            }
            return dp[p][mask]
        }

        dfs(1, 0)
        val res = mutableListOf(0)
        var mask = 1
        while (Integer.bitCount(mask) < nums.size) {
            res.add(track[res.last()][mask])
            mask = mask or (1 shl res.last())
        }
        return res.toIntArray()
    }
}
