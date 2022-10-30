package com.ypwang.medium

class Solution2457 {
    private fun sum(n: Long): Int {
        var n = n
        var res = 0
        while (n > 0) {
            res += (n % 10).toInt()
            n /= 10
        }
        return res
    }

    fun makeIntegerBeautiful(n: Long, target: Int): Long {
        var n = n
        val n0 = n
        var base = 1L
        while (sum(n) > target) {
            n = n / 10 + 1
            base *= 10
        }
        return n * base - n0
    }
}