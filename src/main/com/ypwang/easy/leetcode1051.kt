package com.ypwang.easy

class Solution1051 {
    fun heightChecker(heights: IntArray): Int = heights.zip(heights.sorted()).count{ it.first != it.second }
}