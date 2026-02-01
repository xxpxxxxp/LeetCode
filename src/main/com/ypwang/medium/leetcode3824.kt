package com.ypwang.medium

class Solution3824 {
    fun minimumK(nums: IntArray): Int {
        var left = 1L
        var right = nums.fold(0L) { acc, i -> acc + i }
        while (left < right) {
            val k = (left + right) / 2
            val ops = nums.sumOf { (k - 1 + it) / k }
            if (ops > k * k)
                left = k + 1
            else
                right = k
        }
        return left.toInt()
    }
}
