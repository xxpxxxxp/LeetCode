package com.ypwang.easy

class Solution1266 {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var sum = 0
        for (i in 0 until points.lastIndex) {
            val (x1, y1) = points[i]
            val (x2, y2) = points[i+1]

            sum += maxOf(Math.abs(x1-x2), Math.abs(y1-y2))
        }

        return sum
    }
}

fun main() {
    println(Solution1266().minTimeToVisitAllPoints(arrayOf(intArrayOf(1,1), intArrayOf(3,4), intArrayOf(-1,0))))
    println(Solution1266().minTimeToVisitAllPoints(arrayOf(intArrayOf(3,2), intArrayOf(-2,2))))
}