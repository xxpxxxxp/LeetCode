package com.ypwang.medium

class Solution4026 {
    fun maximumGap(skill: String, station: String): Int {
        val n = skill.length
        val m = station.length

        val left = IntArray(n)
        var j = -1
        for (i in 0 until n) {
            j = station.indexOf(skill[i], j + 1)
            left[i] = j
        }

        val right = IntArray(n)
        j = m
        for (i in n - 1 downTo 0) {
            j = station.lastIndexOf(skill[i], j - 1)
            right[i] = j
        }

        var res = 0
        for (i in 0 until n - 1)
            res = maxOf(res, right[i + 1] - left[i])
        return res
    }
}
