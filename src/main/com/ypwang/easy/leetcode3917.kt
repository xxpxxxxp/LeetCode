package com.ypwang.easy

class Solution3917 {
    fun countOppositeParity(nums: IntArray): IntArray {
        val arr = intArrayOf(0, 0)
        val rst = IntArray(nums.size)

        for (j in nums.indices.reversed()) {
            rst[j] = arr[1 - (nums[j] % 2)]
            arr[nums[j] % 2]++
        }

        return rst
    }
}
