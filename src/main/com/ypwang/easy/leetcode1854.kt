package com.ypwang.easy

class Solution1854 {
    fun maximumPopulation(logs: Array<IntArray>): Int {
        val arr = IntArray(101)

        for ((s, e) in logs) {
            arr[s-1950]++
            arr[e-1950]--
        }

        var max = 0
        var d = 0
        var cur = 0
        for ((i, v) in arr.withIndex()) {
            cur += v
            if (cur > max) {
                max = cur
                d = i
            }
        }

        return d + 1950
    }
}