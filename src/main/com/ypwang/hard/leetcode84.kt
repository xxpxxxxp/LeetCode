package com.ypwang.hard

class Solution84 {
    fun largestRectangleArea(heights: IntArray): Int {
        val left = IntArray(heights.size) {-1}
        val right = IntArray(heights.size){heights.size}

        for (i in 1 until heights.size) {
            var p = i-1
            while (p >= 0 && heights[p] >= heights[i]) {
                p = left[p]
            }
            left[i] = p
        }

        for (i in heights.lastIndex-1 downTo 0) {
            var p = i+1
            while (p < heights.size && heights[p] >= heights[i]) {
                p = right[p]
            }
            right[i] = p
        }

        var max = 0
        for (i in 0 until heights.size) {
            val area = (right[i] - left[i] - 1) * heights[i]
            if (area > max) max = area
        }

        return max
    }
}

fun main() {
    println(Solution84().largestRectangleArea(intArrayOf(1,1)))
}