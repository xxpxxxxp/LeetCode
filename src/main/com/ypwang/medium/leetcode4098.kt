package com.ypwang.medium

class Solution4098 {
    fun minimumMaxValue(n: Int, index: Int, value: Int): Long {
        if (value == 1)
            return -1

        var a = value
        var i = 2
        while (1L * i * i <= value) {
            if (value % i == 0) {
                a = i
                break
            }
            i++
        }

        if (index > 0) {
            val left = value - a - 2L * (index - 1)
            if (left <= 0) return -1
        }

        var result = value.toLong()
        val right = n - 1 - index
        if (right > 0)
            result = value + a + 2L * (right - 1)

        return result
    }
}
