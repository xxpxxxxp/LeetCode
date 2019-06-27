package com.ypwang.medium

class Solution1093 {
    fun sampleStats(count: IntArray): DoubleArray {
        var mode = 0
        var modeV = -1
        var min = 256
        var max = -1
        var sum = 0.0
        var cc = 0

        for ((i, c) in count.withIndex()) {
            sum += i * c
            cc += c

            if (c != 0) {
                if (i < min) min = i
                if (i > max) max = i
                if (c > mode) {
                    mode = c
                    modeV = i
                }
            }
        }

        var mid = 0
        val m1 = (cc + 1) / 2
        val m2 = cc / 2 + 1 // m1-th and m2-th items are medians
        var ccc = 0
        for ((i, c) in count.withIndex()) {
            if (ccc < m1 && ccc + c >= m1)
                // find m1-th item.
                mid += i
            if (ccc < m2 && ccc + c >= m2)
                // find m2-th item.
                mid += i
            ccc += c
        }

        return doubleArrayOf(min.toDouble(), max.toDouble(), sum / cc, mid / 2.0, modeV.toDouble())
    }
}