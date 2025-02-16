package com.ypwang.hard

class Solution3449 {
    fun maxScore(points: IntArray, m: Int): Long {
        val n = points.size

        fun possible(bound: Long): Boolean {
            val req = points.map { (bound + it - 1) / it }.toLongArray()
            var steps = 0L

            for (i in req.indices) {
                if (req[i] != 0L) {
                    steps += 2 * req[i] - 1
                    if (i + 1 < n)
                        req[i + 1] = maxOf(0, req[i + 1] - (req[i] - 1))
                } else if (i < n - 1)
                    steps += 1
            }
            return steps <= m
        }

        var lo = 0L
        var hi = 1000000L * m / n + 1
        while (lo < hi) {
            val mi = (lo + hi + 1) / 2
            if (possible(mi))
                lo = mi
            else
                hi = mi - 1
        }
        return lo
    }
}
