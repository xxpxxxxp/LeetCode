package com.ypwang.hard

import java.util.TreeSet

class Solution3636 {
    fun subarrayMajority(nums: IntArray, queries: Array<IntArray>): IntArray {
        val n = nums.size
        val q = queries.size

        val c = mutableMapOf<Int, Int>()
        val sl = TreeSet<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))

        val blockSize = maxOf(1, n / Math.sqrt(q.toDouble()).toInt())
        val indexedQueries = queries.mapIndexed { i, (l, r, t) -> Triple(l, r, i) to t }
        val sortedQueries = indexedQueries.sortedWith(compareBy(
            { it.first.first / blockSize },
            { if ((it.first.first / blockSize) % 2 == 0) it.first.second else -it.first.second }
        ))

        val result = IntArray(q) { -1 }
        var currL = 0
        var currR = 0

        fun add(pos: Int) {
            val x = nums[pos]
            val prev = c.getOrDefault(x, 0)
            if (prev > 0)
                sl.remove(prev to -x)
            c[x] = prev + 1
            sl.add((prev + 1) to -x)
        }

        fun remove(pos: Int) {
            val x = nums[pos]
            val prev = c[x] ?: return
            sl.remove(prev to -x)
            if (prev == 1) {
                c.remove(x)
            } else {
                c[x] = prev - 1
                sl.add((prev - 1) to -x)
            }
        }

        for ((query, threshold) in sortedQueries) {
            val (L, R, idx) = query

            while (currR <= R) {
                add(currR)
                currR++
            }
            while (currL > L) {
                currL--
                add(currL)
            }
            while (currR > R + 1) {
                currR--
                remove(currR)
            }
            while (currL < L) {
                remove(currL)
                currL++
            }

            if (sl.isEmpty()) {
                result[idx] = -1
            } else {
                val (cnt, x) = sl.last()
                result[idx] = if (cnt < threshold) -1 else -x
            }
        }

        return result
    }
}
