package com.ypwang.hard

class Solution10033 {
    fun incremovableSubarrayCount(nums: IntArray): Int {
        var j = nums.lastIndex
        while (j > 0 && nums[j-1] < nums[j])
            j--

        if (j == 0)
            return nums.size * (nums.size + 1) / 2

        var rst = nums.size - j + 1

        for (i in 1 until nums.size) {
            j = maxOf(i+1, j)
            while (j < nums.size && nums[j] <= nums[i-1])
                j++

            rst += nums.size - j + 1
            if (nums[i - 1] >= nums[i])
                break
        }

        return rst
    }
}

fun main() {
    println(Solution10033().incremovableSubarrayCount(intArrayOf(1,2,3,4)))
    println(Solution10033().incremovableSubarrayCount(intArrayOf(6,5,7,8)))
    println(Solution10033().incremovableSubarrayCount(intArrayOf(8,7,6,6)))
}