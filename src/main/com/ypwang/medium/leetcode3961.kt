package com.ypwang.medium

class Solution3961 {
    fun maxRatings(units: Array<IntArray>): Long {
        val n = units.size

        if (n == 1)
            return units[0].min().toLong()

        var sum = 0L
        var allSingle = true

        for (unit in units) {
            if (unit.size == 1) {
                sum += unit[0].toLong()
            } else {
                allSingle = false
                break
            }
        }

        if (allSingle)
            return sum

        sum = 0L
        var minm = Int.MAX_VALUE
        var sminm = Int.MAX_VALUE

        for (unit in units) {
            var mn1 = Int.MAX_VALUE
            var mn2 = Int.MAX_VALUE

            for (x in unit) {
                if (x < mn1) {
                    mn2 = mn1
                    mn1 = x
                } else if (x < mn2) {
                    mn2 = x
                }
            }

            sum += mn2.toLong()
            minm = minOf(minm, mn1)
            sminm = minOf(sminm, mn2)
        }

        return minm.toLong() + sum - sminm.toLong()
    }
}
