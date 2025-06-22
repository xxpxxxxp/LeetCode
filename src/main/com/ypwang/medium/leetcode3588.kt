package com.ypwang.medium

class Solution3588 {
    fun maxArea(coords: Array<IntArray>): Long {
        val x = coords.groupBy { it[0] }.mapValues { it.value.map { p -> p[1] } }.toList()
        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        for ((cx, _) in x) {
            max = maxOf(max, cx)
            min = minOf(min, cx)
        }

        var rst = 0L
        for ((cx, ys) in x) {
            val minY = ys.min()
            val maxY = ys.max()

            rst = maxOf(rst, (maxY - minY).toLong() * (max - cx), (maxY - minY).toLong() * (cx - min))
        }

        val y = coords.groupBy { it[1] }.mapValues { it.value.map { p -> p[0] } }.toList()
        max = Int.MIN_VALUE
        min = Int.MAX_VALUE
        for ((cy, _) in y) {
            max = maxOf(max, cy)
            min = minOf(min, cy)
        }

        for ((cy, xs) in y) {
            val minX = xs.min()
            val maxX = xs.max()

            rst = maxOf(rst, (maxX - minX).toLong() * (max - cy), (maxX - minX).toLong() * (cy - min))
        }

        return if (rst == 0L) -1L else rst
    }
}

fun main() {
    println(Solution3588().maxArea(arrayOf(
        intArrayOf(1,2), intArrayOf(4,9), intArrayOf(4,7)
    )))
    println(Solution3588().maxArea(arrayOf(
        intArrayOf(1,1), intArrayOf(1,2), intArrayOf(3,2), intArrayOf(3,3)
    )))
}