package com.ypwang.easy

class Solution2529 {
    fun maximumCount(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex

        // find left most 0
        while (left < right) {
            val mid = (left + right) / 2
            if (nums[mid] < 0)
                left = mid+1
            else
                right = mid
        }

        if (left == nums.lastIndex && nums.last() < 0)
            return nums.size
        val l = left

        left = 0
        right = nums.lastIndex

        // find right most 0
        while (left < right) {
            val mid = (left + right + 1) / 2
            if (nums[mid] <= 0)
                left = mid
            else
                right = mid-1
        }

        if (left == 0 && nums.first() > 0)
            return nums.size
        return maxOf(l, nums.size - left - 1)
    }
}

fun main() {
    println(Solution2529().maximumCount(intArrayOf(5,20,66,1314)))
    println(Solution2529().maximumCount(intArrayOf(-3,-2,-1,0,0,1,2)))
    println(Solution2529().maximumCount(intArrayOf(-2,-1,-1,1,2,3)))
}