package com.ypwang.easy

class Solution {
    fun countGoodRectangles(rectangles: Array<IntArray>): Int {
        val max = rectangles.map { it.min()!! }.max()!!
        return rectangles.count { it.min() == max }
    }
}