package com.ypwang.medium

class Solution1870 {
    fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
        if (dist.size >= hour+1)
            return -1

        var left = 1
        var right = 10000000

        while (left < right) {
            val mid = (left + right) / 2
            if (dist.dropLast(1).sumBy { (it + mid - 1) / mid } + dist.last().toDouble() / mid > hour)
                left = mid + 1
            else
                right = mid
        }

        return left
    }
}

fun main() {
    println(Solution1870().minSpeedOnTime(intArrayOf(1,3,2), 2.7))
}