package com.ypwang.medium

class Solution2592 {
    fun maximizeGreatness(nums: IntArray): Int {
        nums.sort()
        var rst = 0
        for (n in nums) {
            if (n > nums[rst])
                rst++
        }

        return rst
    }
}