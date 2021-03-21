package com.ypwang.easy

class Solution1800 {
    fun maxAscendingSum(nums: IntArray): Int {
        var rst = nums[0]
        var sum = nums[0]

        for (i in 1 until nums.size) {
            if (nums[i-1] < nums[i])
                sum += nums[i]
            else {
                rst = maxOf(sum, rst)
                sum = nums[i]
            }
        }

        return maxOf(rst, sum)
    }
}