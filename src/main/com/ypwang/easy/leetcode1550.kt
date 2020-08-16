package com.ypwang.easy

class Solution1550 {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var count = 0
        for (i in arr) {
            when (i % 2) {
                0 -> count = 0
                1 -> {
                    count++
                    if (count >= 3)
                        return true
                }
            }
        }

        return false
    }
}