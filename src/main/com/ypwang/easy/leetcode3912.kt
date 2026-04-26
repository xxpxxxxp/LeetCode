package com.ypwang.easy

class Solution3912 {
    fun findValidElements(nums: IntArray): List<Int> {
        val n = nums.size
        val valid = BooleanArray(n)

        valid[0] = true
        valid[n - 1] = true
        var max = nums[0]
        for (i in 1 until n) {
            if (nums[i] > max)
                valid[i] = true

            max = maxOf(nums[i], max)
        }

        max = nums[n - 1]
        for (i in n - 2 downTo 0) {
            if (max < nums[i])
                valid[i] = true

            max = maxOf(max, nums[i])
        }

        return nums.zip(valid.toList()).filter { it.second }.map { it.first }
    }
}
