package com.ypwang.easy

class Solution3833 {
    fun dominantIndices(nums: IntArray): Int {
        var sum = nums.last()
        var rst = 0
        for (i in nums.lastIndex-1 downTo 0) {
            val average = sum / (nums.size - i - 1)
            if (average < nums[i])
                rst++
            sum += nums[i]
        }

        return rst
    }
}
