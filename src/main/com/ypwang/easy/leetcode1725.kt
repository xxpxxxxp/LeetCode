package com.ypwang.easy

class Solution1725 {
    fun countGoodRectangles(rectangles: Array<IntArray>): Int {
        val max = rectangles.map { it.minOrNull()!! }.maxOrNull()!!
        return rectangles.count { it.minOrNull() == max }
    }
}