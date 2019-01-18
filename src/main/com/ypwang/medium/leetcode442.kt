package com.ypwang.medium

class Solution442 {
    fun findDuplicates(nums: IntArray): List<Int> {
        var i = 0
        while (i < nums.size) {
            if (nums[i] != nums[nums[i] - 1]) {
                val tmp = nums[nums[i] - 1]
                nums[nums[i] - 1] = nums[i]
                nums[i] = tmp
            } else {
                i++
            }
        }

        val rst = mutableListOf<Int>()
        for (i in 0 until nums.size) {
            if (nums[i] != i + 1) {
                rst.add(nums[i])
            }
        }
        return rst
    }
}