package com.ypwang.hard

class Solution2366 {
    fun minimumReplacement(nums: IntArray): Long {
        var prev = nums.last()
        var ans = 0L
        for (i in nums.size - 2 downTo 0) {
            var noOfTime = nums[i] / prev
            if (nums[i] % prev != 0) {
                noOfTime++
                prev = nums[i] / noOfTime
            }
            ans += noOfTime - 1
        }
        return ans
    }
}