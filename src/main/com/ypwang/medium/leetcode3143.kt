package com.ypwang.medium

class Solution3143 {
    fun maxPointsInsideSquare(points: Array<IntArray>, s: String): Int {
        val tags = IntArray(26) { Int.MAX_VALUE }
        var square = Int.MAX_VALUE
        for ((i, p) in points.withIndex()) {
            var sz = maxOf(Math.abs(p[0]), Math.abs(p[1]))
            val tag = s[i] - 'a'
            if (tags[tag] > sz) {
                val t = tags[tag]
                tags[tag] = sz
                sz = t
            }
            square = minOf(square, sz)
        }
        return tags.count { it < square }
    }
}
