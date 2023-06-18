package com.ypwang.easy

class Solution2739 {
    fun distanceTraveled(mainTank: Int, additionalTank: Int): Int {
        var total = 0

        var m = mainTank
        var a = additionalTank

        while (m >= 5) {
            val d = m / 5
            total += d * 5
            m = m - d * 5 + minOf(d, a)
            a -= minOf(d, a)
        }

        return (total + m) * 10
    }
}