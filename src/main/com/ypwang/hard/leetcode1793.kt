package com.ypwang.hard

class Solution1793 {
    fun maximumScore(nums: IntArray, k: Int): Int {
        var rst = nums[k]
        var min = nums[k]
        var i = k
        var j = k

        while (i > 0 && j < nums.lastIndex) {
            min = if (nums[i-1] > nums[j+1]) {
                minOf(min, nums[--i])
            } else {
                minOf(min, nums[++j])
            }

            rst = maxOf(rst, min * (j - i + 1))
        }

        while (i > 0) {
            min = minOf(min, nums[--i])
            rst = maxOf(rst, min * (j - i + 1))
        }

        while (j < nums.lastIndex) {
            min = minOf(min, nums[++j])
            rst = maxOf(rst, min * (j - i + 1))
        }

        return rst
    }
}