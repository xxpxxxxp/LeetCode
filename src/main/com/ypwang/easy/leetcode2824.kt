package com.ypwang.easy

class Solution2824 {
    fun countPairs(nums: List<Int>, target: Int): Int {
        val nums = nums.sorted().toIntArray()
        val n = nums.size
        var l = 0
        var h = n - 1
        var rst = 0
        while (l < h) {
            if (nums[l] + nums[h] < target) {
                rst += h - l
                l++
            } else
                h--
        }

        return rst
    }
}
