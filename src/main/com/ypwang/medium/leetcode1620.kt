package com.ypwang.medium

class Solution1620 {
    fun bestCoordinate(towers: Array<IntArray>, radius: Int): IntArray {
        var max = 0
        var x = 0
        var y = 0

        for (i in 0 until 51) {
            for (j in 0 until 51) {
                val t = towers.sumBy {
                    val dx = i - it[0]
                    val dy = j - it[1]
                    val d = Math.sqrt(dx * dx + dy * dy.toDouble())
                    if (d <= radius)
                        (it[2] / (1 + d)).toInt()
                    else
                        0
                }

                if (t > max) {
                    max = t
                    x = i
                    y = j
                }
            }
        }

        return intArrayOf(x, y)
    }
}