package com.ypwang.medium

class Solution3201 {
    fun maximumLength(nums: IntArray): Int {
        var c = nums[0] % 2
        var odd = 0
        var even = 0
        var both = 0
        for (num in nums) {
            if (num % 2 == 0)
                even++
            else
                odd++
            if (num % 2 == c) {
                both++
                c = 1 - c
            }
        }
        return maxOf(both, even, odd)
    }
}
