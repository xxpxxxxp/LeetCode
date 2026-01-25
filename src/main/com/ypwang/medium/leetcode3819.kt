package com.ypwang.medium

class Solution3819 {
    fun rotateElements(nums: IntArray, k: Int): IntArray {
        val idx = nums.withIndex().filter { it.value >= 0 }

        if (idx.isEmpty())
            return nums

        val rotate = k % idx.size
        val values = idx.map { it.value }

        val pre = values.take(rotate).reversed()
        val post = values.drop(rotate).reversed()
        val newVals = (pre + post).reversed()
        idx.map { it.index }.zip(newVals).forEach {
            nums[it.first] = it.second
        }

        return nums
    }
}
