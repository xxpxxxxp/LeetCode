package com.ypwang.easy

class Solution2960 {
    fun countTestedDevices(batteryPercentages: IntArray): Int {
        var c = 0
        for (v in batteryPercentages)
            if (v > c)
                c++

        return c
    }
}