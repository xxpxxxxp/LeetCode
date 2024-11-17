package com.ypwang.easy

class Solution3354 {
    fun countValidSelections(nums: IntArray): Int {
        val sum = nums.sum()!!
        var rst = 0
        var preSum = 0
        for (i in nums) {
            if (i == 0) {
                val right = sum - preSum
                rst += maxOf(0, 2 - Math.abs(preSum - right))
            }

            preSum += i
        }
        return rst
    }
}
