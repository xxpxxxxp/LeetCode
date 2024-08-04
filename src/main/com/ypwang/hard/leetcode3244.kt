package com.ypwang.hard

class Solution3244 {
    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val rst = IntArray(queries.size)
        val map = HashMap<Int, Int>()

        for (i in 0 until n - 1)
            map[i] = i + 1

        for ((i, q) in queries.withIndex()) {
            val (u, v) = q

            if (u !in map || map[u]!! >= v) {
                rst[i] = map.size
                continue
            }

            var j = map[u]!!
            while (j < v)
                j = map.remove(j)!!

            map[u] = v
            rst[i] = map.size
        }

        return rst
    }
}
