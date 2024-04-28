package com.ypwang.easy

class Solution3069 {
    fun resultArray(nums: IntArray): IntArray {
        val n1 = mutableListOf(nums[0])
        val n2 = mutableListOf(nums[1])
        for (i in 2 until nums.size) {
            if (n1.last() > n2.last())
                n1.add(nums[i])
            else
                n2.add(nums[i])
        }

        return (n1 + n2).toIntArray()
    }
}
