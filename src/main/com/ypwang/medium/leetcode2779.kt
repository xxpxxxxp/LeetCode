package com.ypwang.medium

class Solution2779 {
    fun maximumBeauty(nums: IntArray, k: Int): Int {
        nums.sort()
        var rst = 0
        var j = 0

        for ((i, v) in nums.withIndex()) {
            while (j < nums.size && nums[j] - k <= v + k)
                j++
            rst = maxOf(rst, j-i)
        }

        return rst
    }
}