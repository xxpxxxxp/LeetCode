package com.ypwang.medium

class Solution3634 {
    fun minRemoval(nums: IntArray, k: Int): Int {
        nums.sort()

        var maxSize = 0
        var left = 0

        for (right in 0 until nums.size) {
            while (nums[right] > k.toLong() * nums[left])
                left++

            maxSize = maxOf(maxSize, right - left + 1)
        }

        return nums.size - maxSize
    }
}
