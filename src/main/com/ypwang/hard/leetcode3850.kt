package com.ypwang.hard

class Solution3850 {
    private fun gcd(a: Long, b: Long): Long = if (a == 0L) b else gcd(b % a, a)

    fun countSequences(nums: IntArray, k: Long): Int {
        val n = nums.size
        val dp = mutableMapOf<LongArray, Int>()

        fun solve(index: Int, numerator: Long, denominator: Long): Int {
            var numerator = numerator
            var denominator = denominator
            val x = gcd(numerator, denominator)
            numerator /= x
            denominator /= x

            if (index == n)
                return if (numerator == k * denominator) 1 else 0

            val temp = longArrayOf(index.toLong(), numerator, denominator)

            if (temp !in dp)
                dp[temp] = solve(index + 1, numerator * nums[index], denominator) +
                        solve(index + 1, numerator, denominator * nums[index]) +
                        solve(index + 1, numerator, denominator)

            return dp[temp]!!
        }

        return solve(0, 1, 1)
    }
}
