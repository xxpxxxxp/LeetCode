package com.ypwang.hard

class Solution850 {
    fun rectangleArea(rectangles: Array<IntArray>): Int {
        val x = rectangles.flatMap { listOf(it[0], it[2]) }.toSet().toList().toIntArray()
        x.sort()

        val xSign = IntArray(x.size - 1)
        val reverse = x.withIndex().map { it.value to it.index }.toMap()

        var cur = 0
        var xSum = 0L
        var rst = 0L

        for ((y, x1, x2, sign) in rectangles.flatMap { listOf(intArrayOf(it[1], it[0], it[2], 1), intArrayOf(it[3], it[0], it[2], -1)) }
                .sortedBy { it[0] }) {
            rst = (rst + (y - cur) * xSum) % 1000000007
            cur = y
            for (i in reverse[x1]!! until reverse[x2]!!) xSign[i] += sign
            xSum = xSign.withIndex().filter { it.value > 0 }.map { (x[it.index + 1] - x[it.index]).toLong() }.sum()
        }

        return rst.toInt()
    }
}

fun main() {
    println(Solution850().rectangleArea(arrayOf(
            intArrayOf(0,0,1,1),
            intArrayOf(2,2,3,3)
    )))

    println(Solution850().rectangleArea(arrayOf(
            intArrayOf(0,0,2,2),
            intArrayOf(1,0,2,3),
            intArrayOf(1,0,3,1)
    )))

    println(Solution850().rectangleArea(arrayOf(
            intArrayOf(0,0,1000000000,1000000000)
    )))
}