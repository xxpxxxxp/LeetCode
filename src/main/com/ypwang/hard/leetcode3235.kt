package com.ypwang.hard

class Solution3235 {
    fun canReachCorner(X: Int, Y: Int, circles: Array<IntArray>): Boolean {
        val n = circles.size
        val dsu = IntArray(n + 2) { it }

        fun find(i: Int): Int {
            if (dsu[i] != i)
                dsu[i] = find(dsu[i])
            return dsu[i]
        }

        for (i in 0 until n) {
            val (x, y, r) = circles[i]
            if (x - r <= 0 || y + r >= Y)
                dsu[find(n)] = find(i)

            if (x + r >= X || y - r <= 0)
                dsu[find(n + 1)] = find(i)

            for (j in 0 until i) {
                val (x2, y2, r2) = circles[j]
                if ((x - x2) * (x - x2) + (y - y2) * (y - y2) <= (r + r2) * (r + r2))
                    dsu[find(i)] = find(j)
            }
        }

        return find(n) != find(n + 1)
    }
}
