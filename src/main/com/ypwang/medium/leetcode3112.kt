package com.ypwang.medium

import java.util.PriorityQueue

class Solution3112 {
    fun minimumTime(n: Int, edges: Array<IntArray>, disappear: IntArray): IntArray {
        val conn = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for ((x, y, w) in edges) {
            conn[x].add(y to w)
            conn[y].add(x to w)
        }

        val rst = IntArray(n) { Int.MAX_VALUE }
        val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        heap.add(0 to 0)
        while (heap.isNotEmpty()) {
            val (node, weight) = heap.poll()
            if (rst[node] < weight)
                // already visited this node before
                continue
            if (disappear[node] <= weight)
                // node disappeared before we visit here
                continue

            rst[node] = weight
            for ((next, w) in conn[node])
                heap.offer(next to weight+w)
        }

        return rst.map { if (it == Int.MAX_VALUE) -1 else it }.toIntArray()
    }
}

fun main() {
    println(Solution3112().minimumTime(3, arrayOf(intArrayOf(0,1,2), intArrayOf(1,2,1), intArrayOf(0,2,4)), intArrayOf(1,1,5)).toList())
}
