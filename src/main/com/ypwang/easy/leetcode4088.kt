package com.ypwang.easy

class Solution4088 {
    fun peakValleyDifference(nums: IntArray): Int {
        var peakSum = 0
        var valleySum = 0

        for (i in 1..<nums.size - 1) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peakSum += nums[i]
            } else if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                valleySum += nums[i]
            }
        }

        return peakSum - valleySum
    }
}
