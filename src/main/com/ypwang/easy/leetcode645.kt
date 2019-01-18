package com.ypwang.easy

class Solution645 {
    fun findErrorNums(nums: MutableList<Int>) {
        for (i in 0 until nums.size) {
            while (nums[i] != nums[nums[i]-1]) {
                val tmp = nums[nums[i]-1]
                nums[nums[i]-1] = nums[i]
                nums[i] = tmp
            }
        }
    }
}

fun main(args: Array<String>) {
    Solution645().findErrorNums(mutableListOf(4,6,4,7,2,5,1))
}