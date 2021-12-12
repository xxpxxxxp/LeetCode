package com.ypwang.easy

class Solution2103 {
    fun countPoints(rings: String): Int {
        val rods = IntArray(10)

        for (n in 0 until rings.length/2) {
            val c =
                when (rings[2 * n]) {
                    'R' -> 1
                    'B' -> 2
                    else -> 4
                }

            val r = rings[2 * n + 1] - '0'

            rods[r] = rods[r] or c
        }

        return rods.count { it == 7 }
    }
}