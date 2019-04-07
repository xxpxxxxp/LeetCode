package com.ypwang.medium

class Solution713 {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (nums.isEmpty())
            return 0

        var m = 1
        var i = 0
        var j = 0
        var count = 0

        while (j < nums.size) {
            m *= nums[j]
            j++

            while (i < j && m >= k) {
                m /= nums[i]
                i++
            }

            count += j - i
        }

        return count
    }
}

fun main() {
    println(Solution713().numSubarrayProductLessThanK(intArrayOf(10, 5, 2, 6), 100))
}