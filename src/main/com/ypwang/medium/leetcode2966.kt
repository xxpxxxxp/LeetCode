package com.ypwang.medium

class Solution2966 {
    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        nums.sort()

        val rst = (0 until nums.size / 3).map { intArrayOf(nums[it*3], nums[it*3+1], nums[it*3+2]) }.toTypedArray()

        return if (rst.all { it[2] - it[0] <= k })
            rst
        else
            arrayOf()
    }
}