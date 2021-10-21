package com.ypwang.hard

import java.util.*

class Solution2045 {
    fun secondMinimum(n: Int, edges: Array<IntArray>, time: Int, change: Int): Int {
        val dis = Array(n+1) {  mutableListOf<Int>() }
        dis[1].add(0)
        val graph = mutableMapOf<Int, MutableList<Int>>()
        for ((a, b) in edges) {
            graph.getOrPut(a) { mutableListOf() }.add(b)
            graph.getOrPut(b) { mutableListOf() }.add(a)
        }

        val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        heap.add(0 to 1)

        while (true) {
            val (dist, idx) = heap.poll()
            if (idx == n && dis[n].size == 2)
                return dis[n].maxOrNull()!!

            for (next in graph.getOrDefault(idx, mutableListOf())) {
                val cand =
                    if (dist / change % 2 == 0)
                        dist + time
                    else
                        (dist + 2 * change - 1) / (2 * change) * (2 * change) + time
                val l = dis[next].size

                if (l == 0 || (l == 1 && dis[next][0] != cand) || (l == 2 && cand < dis[next].maxOrNull()!! && cand != dis[next].minOrNull()!!)) {
                    dis[next].add(cand)
                    heap.add(cand to next)
                }

                if (dis[next].size == 3)
                    dis[next].remove(dis[next].maxOrNull()!!)
            }
        }
    }
}

fun main() {
    println(Solution2045().secondMinimum(5,
        arrayOf(intArrayOf(1,2), intArrayOf(1,3), intArrayOf(1,4), intArrayOf(3,4), intArrayOf(4,5)),
        3,5
    ))
}