package com.ypwang.easy

class Solution2903 {
    fun findIndices(nums: IntArray, indexDifference: Int, valueDifference: Int): IntArray {
        var mini = 0
        var maxi = 0
        for (i in indexDifference until nums.size) {
            if (nums[i - indexDifference] < nums[mini])
                mini = i - indexDifference
            if (nums[i - indexDifference] > nums[maxi])
                maxi = i - indexDifference
            if (nums[i] - nums[mini] >= valueDifference)
                return intArrayOf(mini, i)
            if (nums[maxi] - nums[i] >= valueDifference)
                return intArrayOf(maxi, i)
        }
        return intArrayOf(-1, -1)
    }
}