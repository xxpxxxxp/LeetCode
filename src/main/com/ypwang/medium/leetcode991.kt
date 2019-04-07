package com.ypwang.medium

class Solution991 {
    fun brokenCalc(X: Int, Y: Int): Int {
        var count = 0

        var x = X
        var y = Y

        while (x < y) {
            when (y % 2) {
                0 -> y /= 2
                1 -> y += 1
            }
            count++
        }

        count += (x - y)
        return count
    }
}