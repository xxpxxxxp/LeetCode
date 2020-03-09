package com.ypwang.easy

class Solution1365 {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val count = IntArray(101)
        val sum = IntArray(101)
        for (n in nums) count[n]++
        for (i in 1 until count.size) sum[i] += sum[i-1] + count[i-1]
        return nums.map { sum[it] }.toIntArray()
    }
}