package com.ypwang.hard

class Solution1799 {
    private fun gcd(a: Int, b: Int): Int {
        if (a > b)
            return gcd(b, a)

        if (a == 0)
            return b

        return gcd(b % a, a)
    }

    fun maxScore(nums: IntArray): Int {
        val gcds = Array(nums.size) { IntArray(nums.size) }
        for (i in nums.indices) {
            for (j in i+1 until nums.size)
                gcds[i][j] = gcd(nums[i], nums[j])
        }

        val dp = IntArray(1 shl nums.size) { Int.MIN_VALUE }

        fun calc(level: Int, mask: Int): Int {
            if (level == 0)
                return 0

            if (dp[mask] == Int.MIN_VALUE) {
                for (i in nums.indices) {
                    for (j in i+1 until nums.size) {
                        if (mask and (1 shl i) != 0 && mask and (1 shl j) != 0) {
                            dp[mask] = maxOf(dp[mask], level * gcds[i][j] + calc(level - 1, mask xor (1 shl i) xor (1 shl j)))
                        }
                    }
                }
            }

            return dp[mask]
        }

        return calc(nums.size / 2, (1 shl nums.size) - 1)
    }
}

fun main() {
    println(Solution1799().maxScore(intArrayOf(1,2)))
}