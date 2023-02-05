package com.ypwang.medium

class Solution2560 {
    fun minCapability(nums: IntArray, k: Int): Int {
        var left = 1
        var right = nums.max()
        while (left < right) {
            val mid = (left + right) / 2
            var i = 0
            var take = 0
            while (i < nums.size) {
                if (nums[i] <= mid) {
                    take++
                    i++
                }
                i++
            }
            if (take >= k)
                right = mid
            else
                left = mid + 1
        }
        return left
    }
}