package com.ypwang.medium

class Solution10032 {
    fun largestPerimeter(nums: IntArray): Long {
        nums.sortDescending()
        var sum = nums.fold(0L) { a, b -> a + b }

        for ((i, n) in nums.withIndex()) {
            if (nums.size - i < 3)
                return -1

            if (sum > 2 * n)
                return sum

            sum -= n
        }

        return -1
    }
}