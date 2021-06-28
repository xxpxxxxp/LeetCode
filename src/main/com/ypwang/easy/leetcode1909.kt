package com.ypwang.easy

class Solution1909 {
    fun canBeIncreasing(nums: IntArray): Boolean {
        if (nums.size <= 2)
            return true

        var i = 0
        while (i < nums.lastIndex && nums[i] < nums[i+1])
            i++

        if (i == nums.lastIndex)
            return true

        var j = nums.lastIndex
        while (j > i && nums[j] > nums[j-1])
            j--

        return i+1 == j && ((i == 0 || nums[i-1] < nums[j]) || (j == nums.lastIndex || nums[i] < nums[j+1]))
    }
}

fun main() {
    println(Solution1909().canBeIncreasing(intArrayOf(100,21,100)))
}