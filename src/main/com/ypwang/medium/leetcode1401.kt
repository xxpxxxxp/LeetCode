package com.ypwang.medium

class Solution1401 {
    fun checkOverlap(radius: Int, x_center: Int, y_center: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
        val yy = if (y_center in y1..y2) 0 else minOf(Math.abs(y1 - y_center), Math.abs(y2 - y_center))
        val xx = if (x_center in x1..x2) 0 else minOf(Math.abs(x1 - x_center), Math.abs(x2 - x_center))
        return xx * xx + yy * yy <= radius * radius
    }
}