package com.ypwang.easy

class Solution4120 {
    fun countDominantElements(nums: IntArray): Int {
        var res = 0
        val n = nums.size
        for (i in 0 until n) if (nums[i] * 2 >= nums[maxOf(0, i - 1)] + nums[minOf(n - 1, i + 1)])
            res++
        return res
    }
}
