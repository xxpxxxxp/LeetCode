package com.ypwang.medium

class Solution477 {
    fun totalHammingDistance(nums: IntArray): Int {
        return (0..31).map {
            val mask = 1 shl it
            val c = nums.count { i -> (i and mask) != 0 }
            c * (nums.size - c)
        }.sum()
    }
}