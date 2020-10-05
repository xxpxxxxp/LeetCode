package com.ypwang.medium

class Solution1610 {
    fun visiblePoints(points: List<List<Int>>, angle: Int, location: List<Int>): Int {
        val (x, y) = location
        var count = 0

        val angles = mutableListOf<Double>()
        for ((x1, y1) in points) {
            if (x1 == x && y1 == y)
                count++
            else {
                val dx = x1 - x
                val dy = y - y1
                val anl = Math.atan2(dy.toDouble(), dx.toDouble()).let {
                    if (it < 0) Math.abs(it)
                    else 2 * Math.PI - it
                }
                angles.add(Math.toDegrees(anl))
            }
        }

        val array = angles.sorted().toTypedArray()

        var j = 0
        var max = 0
        for ((i, v) in array.withIndex()) {
            while (j < array.size + i && (array[j % array.size] - v).let { if (it < 0) it + 360.0 else it } <= angle)
                j++

            max = maxOf(max, j - i)
        }

        return max + count
    }
}

fun main() {
    println(Solution1610().visiblePoints(listOf(
            listOf(2,1), listOf(2,2), listOf(3,3)
    ), 90, listOf(1,1)))
}