package com.ypwang.medium

class Solution2001 {
    private fun gcd(a: Int, b: Int): Int {
        if (a > b)
            return gcd(b, a)

        if (a == 0)
            return b

        return gcd(b % a, a)
    }

    fun interchangeableRectangles(rectangles: Array<IntArray>): Long =
        rectangles.map {
            val (w, h) = it
            val d = gcd(w, h)
            "${w/d},${h/d}"
        }.groupBy { it }
            .map { it.value.size }
            .map { it.toLong() * (it-1) / 2 }
            .sum()
}