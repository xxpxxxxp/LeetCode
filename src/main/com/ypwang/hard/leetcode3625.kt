package com.ypwang.hard

import kotlin.math.abs

class Solution3625 {
    private fun getKey(dx: Long, dy: Long): Long =
        (dx shl 32) or (dy and 0xffffffffL)

    private fun count(mp: Map<Long, Map<Long, Long>>): Long {
        var ans = 0L
        for ((_, innerMap) in mp) {
            var total = 0L
            var same = 0L
            for ((_, y) in innerMap) {
                total += y
                same += y * (y - 1) / 2
            }
            ans += total * (total - 1) / 2 - same
        }
        return ans
    }

    private fun gcd(a: Long, b: Long): Long = if (a == 0L) b else gcd(b % a, a)

    fun countTrapezoids(points: Array<IntArray>): Int {
        val n = points.size
        val mp1 = mutableMapOf<Long, MutableMap<Long, Long>>()
        val mp2 = mutableMapOf<Long, MutableMap<Long, Long>>()

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                var dy = (points[j][1] - points[i][1]).toLong()
                var dx = (points[j][0] - points[i][0]).toLong()

                if (dx == 0L) {
                    dy = 1L
                } else if (dy == 0L) {
                    dx = 1L
                } else {
                    val g = gcd(abs(dy), abs(dx))
                    dy /= g
                    dx /= g
                    if (dx < 0) {
                        dx = -dx
                        dy = -dy
                    }
                }

                val s = dx * points[i][1] - dy * points[i][0]
                val key1 = getKey(dx, dy)
                mp1.computeIfAbsent(key1) { mutableMapOf() }
                    .merge(s, 1L, Long::plus)

                val mx = (points[i][0] + points[j][0]).toLong()
                val my = (points[i][1] + points[j][1]).toLong()
                val key2 = getKey(mx, my)
                val subkey = getKey(dx, dy)
                mp2.computeIfAbsent(key2) { mutableMapOf() }
                    .merge(subkey, 1L, Long::plus)
            }
        }

        return (count(mp1) - count(mp2)).toInt()
    }
}
