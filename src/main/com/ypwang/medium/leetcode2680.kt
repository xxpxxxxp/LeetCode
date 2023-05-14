package com.ypwang.medium

class Solution2680 {
    fun maximumOr(nums: IntArray, k: Int): Long {
        val right = IntArray(nums.size)
        for (i in nums.size - 2 downTo 0)
            right[i] = right[i + 1] or nums[i + 1]

        var left = 0
        var res = 0L
        for (i in nums.indices) {
            res = maxOf(res, left.toLong() or (nums[i].toLong() shl k) or right[i].toLong())
            left = left or nums[i]
        }
        return res
    }
}