package com.ypwang.medium

class Solution11 {
    fun maxArea(height: IntArray): Int {
        var start = 0
        var end = height.lastIndex

        fun area() = (end - start) * Math.min(height[start], height[end])

        var area = area()

        while (start < end) {
            if (height[start] > height[end]) {
                val t = height[end]
                while (start < end) {
                    end--
                    if (height[end] > t) {
                        break
                    }
                }
            } else {
                val t = height[start]
                while (start < end) {
                    start++
                    if (height[start] > t) {
                        break
                    }
                }
            }

            val t = area()
            if (t > area)
                area = t
        }

        return area
    }
}

fun main() {
    println(Solution11().maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
}