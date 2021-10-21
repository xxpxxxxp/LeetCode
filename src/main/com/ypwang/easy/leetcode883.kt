package com.ypwang.easy

class Solution883 {
    fun projectionArea(grid: Array<IntArray>): Int {
        var total = 0
        val maxy = Array(grid.size) {0}
        for (array in grid) {
            total += array.maxOrNull() ?: 0
            total += array.count{ it != 0 }

            for ((j, v) in array.withIndex()) {
                if (maxy[j] < v) {
                    maxy[j] = v
                }
            }
        }
        total += maxy.sum()
        return total
    }
}

fun main() {
    println(Solution883().projectionArea(arrayOf(intArrayOf(1,0), intArrayOf(0,2))))
}