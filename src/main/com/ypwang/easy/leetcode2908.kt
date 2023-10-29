package com.ypwang.easy

class Solution2908 {
    fun minimumSum(nums: IntArray): Int {
        val right = IntArray(nums.size)
        right[nums.lastIndex] = nums.last()
        for (i in nums.size - 2 downTo 0)
            right[i] = minOf(right[i+1], nums[i])
        var rst = Int.MAX_VALUE
        var left = nums[0]

        for (i in 1 until nums.size) {
            if (left < nums[i] && nums[i] > right[i])
                rst = minOf(rst, nums[i] + left + right[i])
            left = minOf(left, nums[i])
        }

        return if (rst == Int.MAX_VALUE) -1 else rst
    }
}