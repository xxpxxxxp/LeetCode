package com.ypwang.medium

class Solution2576 {
    fun maxNumOfMarkedIndices(nums: IntArray): Int {
        nums.sort()
        var i = 0
        var j = nums.size / 2
        while (i < nums.size / 2 && j < nums.size) {
            if (2 * nums[i] <= nums[j])
                i++
            ++j
        }
        return i * 2
    }
}