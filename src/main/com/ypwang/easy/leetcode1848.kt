package com.ypwang.easy

class Solution1848 {
    fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
        for (i in nums.indices) {
            if (start + i < nums.size && nums[start + i] == target)
                return i

            if (start >= i && nums[start - i] == target)
                return i
        }

        return -1
    }
}