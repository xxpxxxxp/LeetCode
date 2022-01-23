package com.ypwang.medium

class Solution2145 {
    fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
        var v = 0
        var max = 0
        var min = 0

        for ((i, d) in differences.withIndex()) {
            v += d
            max = maxOf(max, v)
            min = minOf(min, v)

            if (max - min > upper - lower)
                return 0
        }

        return (upper - lower) - (max - min) + 1
    }
}