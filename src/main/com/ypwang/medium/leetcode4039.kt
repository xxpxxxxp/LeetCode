package com.ypwang.medium

class Solution4039 {
    fun sumDecoded(nums: LongArray): Int {
        val n = nums.size
        var sum = 0L
        val MOD = 1000000007L
        for (i in 0 until n) {
            val width = nums[i] % 10
            val d = nums[i] / 10

            var t = d
            var digits = 0
            while (t > 0) {
                digits++
                t /= 10
            }

            var divisor = 1L
            for (j in 0 until digits - width)
                divisor *= 10

            val y = d % divisor
            val x = d / divisor

            val power = calculatePower(x, y, MOD)
            sum = (sum + power) % MOD
        }

        return sum.toInt()
    }

    private fun calculatePower(x: Long, y: Long, MOD: Long): Long {
        var x = x
        var y = y
        var result = 1L
        while (y > 0) {
            if (y % 2 == 1L) {
                result = (result * x) % MOD
            }
            x = (x * x) % MOD
            y /= 2
        }
        return result
    }
}
