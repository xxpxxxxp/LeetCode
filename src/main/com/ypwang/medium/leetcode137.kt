package com.ypwang.medium

class Solution137 {
    fun singleNumber(nums: IntArray): Int {
        var one = 0
        var two = 0
        for (num in nums) {
            one = two.inv() and (one xor num)
            two = one.inv() and (two xor num)
        }
        return one
    }
}