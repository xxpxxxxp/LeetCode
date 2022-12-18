package com.ypwang.hard

class Solution2509 {
    fun cycleLengthQueries(n: Int, queries: Array<IntArray>): IntArray =
        queries.map {
            var (x, y) = it
            var cnt = 1
            while (x != y) {
                if (x > y)
                    x /= 2
                else
                    y /= 2
                cnt++
            }
            cnt
        }.toIntArray()
}