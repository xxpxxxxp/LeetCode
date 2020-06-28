package com.ypwang.easy

class Solution1491 {
    fun average(salary: IntArray): Double {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        var sum = 0

        for (s in salary) {
            min = minOf(min, s)
            max = maxOf(max, s)
            sum += s
        }

        return (sum - min - max).toDouble() / (salary.size - 2)
    }
}