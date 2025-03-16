package com.ypwang.hard

class Solution3490 {
    fun beautifulNumbers(l: Int, r: Int): Int =
        countBeautiful(r) - countBeautiful(l - 1)

    fun countBeautiful(x: Int): Int {
        if (x < 0) return 0
        val digits = x.toString().toCharArray()
        val dp = mutableMapOf<String, Int>()
        return solve(0, 1, 0, 1, digits, dp)
    }

    fun solve(i: Int, tight: Int, sum: Int, prod: Int, digits: CharArray, dp: MutableMap<String, Int>): Int {
        if (i == digits.size)
            return if (sum > 0 && prod % sum == 0) 1 else 0

        val str = "$i - $tight - $sum - $prod"
        if (str !in dp) {
            val limit = if (tight == 1) digits[i] - '0' else 9

            var count = 0
            for (j in 0..limit) {
                val newTight = if (tight == 1 && j == limit) 1 else 0

                val newSum = sum + j
                val newProd = if (j == 0 && sum == 0) 1 else prod * j

                count += solve(i + 1, newTight, newSum, newProd, digits, dp)
            }

            dp[str] = count
        }

        return dp[str]!!
    }
}
