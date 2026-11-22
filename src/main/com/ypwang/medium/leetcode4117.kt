package com.ypwang.medium

class Solution4117 {
    fun minRange(a: Int, b: Int, c: Int): Int {
        val x = minOf(a, b, c)
        val z = maxOf(a, b, c)
        val y = a + b + c - x - z
        return minOf(z - x, y)
    }
}
