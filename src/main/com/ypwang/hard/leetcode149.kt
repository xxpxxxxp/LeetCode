package com.ypwang.hard

class Solution149 {
    private fun gcd(a: Int, b: Int): Int {
        // assuming a < b
        if (a == 0) return b
        return gcd(b % a, a)
    }

    fun maxPoints(points: Array<IntArray>): Int {
        var rst = 0
        for (i in points.indices) {
            val map = mutableMapOf<String, Int>()
            val (x1, y1) = points[i]
            var overlap = 0
            var max = 0
            for (j in i+1 until points.size) {
                val (x2, y2) = points[j]
                val diff = (x2 - x1 to y2 - y1)

                if (diff.first == 0 && diff.second == 0) overlap++
                else {
                    var (m, n) = when {
                        diff.first == 0 -> 0 to Int.MAX_VALUE
                        diff.second == 0 -> Int.MAX_VALUE to 0
                        else -> {
                            val g = gcd(minOf(diff.first, diff.second), maxOf(diff.first, diff.second))
                            (diff.first / g) to (diff.second / g)
                        }
                    }

                    if (n < 0) {
                        m = -m
                        n = -n
                    }

                    val key = "$m@$n"
                    map[key] = map.getOrDefault(key, 0) + 1
                    max = maxOf(max, map[key]!!)
                }
            }

            rst = maxOf(rst, max + overlap + 1)
        }

        return rst
    }
}

fun main() {
    println(Solution149().maxPoints(arrayOf(
            intArrayOf(1,1), intArrayOf(3,2), intArrayOf(5,3), intArrayOf(4,1), intArrayOf(2,3), intArrayOf(1,4)
    )))
}