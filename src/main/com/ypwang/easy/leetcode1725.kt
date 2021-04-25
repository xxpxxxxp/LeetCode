package com.ypwang.easy

class Solution1725 {
    fun countGoodRectangles(rectangles: Array<IntArray>): Int {
        val max = rectangles.map { it.min()!! }.max()!!
        return rectangles.count { it.min() == max }
    }
}