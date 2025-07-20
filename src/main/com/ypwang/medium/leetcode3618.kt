package com.ypwang.medium

import kotlin.math.abs

class Solution3618 {
    private fun isPrime(n: Int): Boolean {
        if (n <= 1) return false
        var i = 2
        while (i * i <= n) {
            if (n % i == 0) return false
            i++
        }
        return true
    }

    fun splitArray(nums: IntArray): Long {
        val n = nums.size
        var sumA = 0L
        var sumB = 0L

        when (n) {
            0 ->
                return 0
            1 ->
                return abs(nums[0]).toLong()
            2 ->
                return abs(nums[0].toLong() + nums[1])
        }

        sumB = (nums[0] + nums[1]).toLong()
        for (i in 2..<n)
            if (isPrime(i))
                sumA += nums[i]
            else
                sumB += nums[i]

        return abs(sumA - sumB)
    }
}
