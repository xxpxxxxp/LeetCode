package com.ypwang.medium

class Solution334 {
    fun increasingTriplet(nums: IntArray): Boolean {
        var min = Int.MAX_VALUE
        var min2 = Int.MAX_VALUE

        for (num in nums) {
            if (num > min2)
                return true

            if (num > min) {
                if (num < min2)
                    min2 = num
            } else if (num < min) {
                min = num
            }
        }

        return false
    }
}