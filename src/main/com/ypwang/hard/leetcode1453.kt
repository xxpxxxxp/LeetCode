package com.ypwang.hard

class Solution1453 {
    fun numPoints(points: Array<IntArray>, r: Int): Int {
        var max = 0

        for (i in points.indices) {
            for (j in i + 1 until points.size) {
                val (a, b) = points[i]
                val (c, d) = points[j]

                val dis = Math.sqrt((c - a) * (c - a) + (d - b) * (d - b).toDouble())
                if (dis <= 2 * r) {
                    val l = Math.sqrt(r * r - dis * dis / 4)

                    for ((ux, uy) in listOf(
                            (a + c) / 2.0 - l * (d - b) / dis to (b + d) / 2.0 + l * (c - a) / dis,
                            (a + c) / 2.0 + l * (d - b) / dis to (b + d) / 2.0 - l * (c - a) / dis
                    ))
                        max = maxOf(max, points.count { (x, y) ->
                            (x - ux) * (x - ux) + (y - uy) * (y - uy) <= r * r + 0.000001
                        })
                }
            }
        }

        return maxOf(max, 1)
    }
}

fun main() {
    println(Solution1453().numPoints(arrayOf(
            intArrayOf(-2,0), intArrayOf(2,0), intArrayOf(0,2), intArrayOf(0,-2)
    ), 2))
    println(Solution1453().numPoints(arrayOf(
            intArrayOf(-2,0), intArrayOf(2,0), intArrayOf(0,2), intArrayOf(0,-2)
    ), 1))
}