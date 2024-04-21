package com.ypwang.hard

class Solution3117 {
    fun minimumValueSum(nums: IntArray, andValues: IntArray): Int {
        val n = nums.size
        val m = andValues.size

        val dp = Array(n) { Array(m) { mutableMapOf<Int, Pair<Int, Boolean>>() } }

        fun helper(mask: Int, i: Int, j: Int): Pair<Int, Boolean> {
            if (i == n && j == m)
                return 0 to true
            if (i == n || j == m)
                return 0 to false

            if (mask in dp[i][j])
                return dp[i][j][mask]!!

            val nextMask = mask and nums[i]
            if (nextMask < andValues[j]) {
                dp[i][j][mask] = 0 to false
                return dp[i][j][mask]!!
            }

            val (r1, p1) = helper(nextMask, i+1, j)
            if (nextMask == andValues[j]) {
                val (r2, p2) = helper(0xffffff, i+1, j+1)
                if (p2) {
                    dp[i][j][mask] = if (p1) (minOf(r1, nums[i] + r2) to true) else (nums[i] + r2 to true)
                    return dp[i][j][mask]!!
                }
            }
            dp[i][j][mask] = r1 to p1
            return dp[i][j][mask]!!
        }

        val (rst, possible) = helper(0xffffff, 0, 0)
        return if (possible) rst else -1
    }
}

fun main() {
    println(Solution3117().minimumValueSum(intArrayOf(1,4,3,3,2), intArrayOf(0,3,3,2)))
}