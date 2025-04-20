package com.ypwang.medium

class Solution3523 {
    fun maximumPossibleSize(nums: IntArray): Int {
        var size = 0
        var prev = -1

        for (num in nums) {
            if (num >= prev) {
                prev = num
                size++
            }
        }

        return size
    }
}
