package com.ypwang.easy

class Solution1037 {
    fun isBoomerang(points: Array<IntArray>): Boolean {
        val diff1 = Pair(points[1][0] - points[0][0], points[1][1] - points[0][1])
        val diff2 = Pair(points[2][0] - points[0][0], points[2][1] - points[0][1])

        return diff1.first * diff2.second != diff1.second * diff2.first
    }
}