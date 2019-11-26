package com.ypwang.hard

class Solution154 {
    fun findMin(nums: IntArray): Int {
        var low = 0
        var high = nums.lastIndex

        while (low < high) {
            val mid = (low + high) / 2
            if (nums[mid] > nums[high]) low = mid+1
            else if (nums[mid] < nums[high]) high = mid
            else high--
        }

        return nums[low]
    }
}