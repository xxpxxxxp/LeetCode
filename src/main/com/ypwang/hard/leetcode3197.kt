package com.ypwang.hard

class Solution3197 {
    fun minimumSum(grid: Array<IntArray>): Int {
        val s = mutableSetOf<Pair<Int, Int>>()
        for (i in grid.indices)
            for (j in grid[0].indices)
                if (grid[i][j] == 1)
                    s.add(Pair(i, j))

        fun f(s: Set<Pair<Int, Int>>, k: Int): Int {
            if (s.isEmpty())
                return 0

            var left = Int.MAX_VALUE
            var top = Int.MAX_VALUE
            var right = Int.MIN_VALUE
            var bottom = Int.MIN_VALUE
            for ((i, j) in s) {
                left = minOf(left, j)
                top = minOf(top, i)
                right = maxOf(right, j)
                bottom = maxOf(bottom, i)
            }

            var res = (bottom - top + 1) * (right - left + 1)

            if (k == 1)
                return res

            for (x in top until bottom) {
                val s1 = s.filter { it.first < x }.toSet()
                res = minOf(res, f(s1, 1) + f(s - s1, k - 1))

                val s2 = s.filter { it.first > x }.toSet()
                res = minOf(res, f(s2, 1) + f(s - s2, k - 1))
            }

            for (y in left until right) {
                val s3 = s.filter { it.second < y }.toSet()
                res = minOf(res, f(s3, 1) + f(s - s3, k - 1))

                val s4 = s.filter { it.second > y }.toSet()
                res = minOf(res, f(s4, 1) + f(s - s4, k - 1))
            }

            return res
        }

        return f(s, 3)
    }
}
