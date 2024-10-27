package com.ypwang.hard

class Solution3336 {
    private val mod = 1000000007
    private val dp = Array(200) { Array(201) { IntArray(201) { -1 } } }

    private fun gcd(a: Int, b: Int): Int =
        if (b == 0) a else gcd(b, a % b)

    private fun solve(i: Int, nums: IntArray, first: Int, second: Int): Int {
        if (i == nums.size)
            return if (first != 0 && second != 0 && first == second) 1 else 0

        if (dp[i][first][second] == -1) {
            // Don't include this element in any subsequence
            val skip = solve(i + 1, nums, first, second)

            // Include this index in the first subsequence
            val take1 = solve(i + 1, nums, gcd(nums[i], first), second)

            // Include this index in the second subsequence
            val take2 = solve(i + 1, nums, first, gcd(nums[i], second))

            // Summing up all the possibilities
            dp[i][first][second] = (skip + take1 + take2) % mod
        }

        return dp[i][first][second]
    }

    fun subsequencePairCount(nums: IntArray): Int =
        solve(0, nums, 0, 0)
}

fun main() {
    println(Solution3336().subsequencePairCount(intArrayOf(21,28,28,20,27)))
}