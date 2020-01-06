package com.ypwang.hard

class Solution391 {
    fun isRectangleCover(rectangles: Array<IntArray>): Boolean {
        var x1 = Int.MAX_VALUE
        var x2 = Int.MIN_VALUE
        var y1 = Int.MAX_VALUE
        var y2 = Int.MIN_VALUE

        val points = mutableSetOf<String>()
        var area = 0

        for ((a, b, c, d) in rectangles) {
            x1 = minOf(x1, a)
            x2 = maxOf(x2, c)
            y1 = minOf(y1, b)
            y2 = maxOf(y2, d)

            for (p in listOf("$a-$b", "$a-$d", "$c-$b", "$c-$d")) {
                if (p in points) points.remove(p)
                else points.add(p)
            }

            area += (c - a) * (d - b)
        }

        return points == setOf("$x1-$y1","$x1-$y2","$x2-$y1","$x2-$y2") &&
                area == (x2 - x1) * (y2 - y1)
    }
}