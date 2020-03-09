package com.ypwang.medium

class Solution1375 {
    fun numTimesAllBlue(light: IntArray): Int {
        var right = 0
        var count = 0

        var rst = 0
        for (bulb in light) {
            right = maxOf(right, bulb)
            count++
            if (right == count) rst++
        }

        return rst
    }
}