package com.ypwang.hard

import java.util.PriorityQueue

class Solution2203 {
    private fun bfs(st: Int, al: Array<MutableList<Pair<Int, Int>>>, visited: LongArray) {
        val heap = PriorityQueue<Pair<Long, Int>>(compareBy{ it.first })
        heap.offer(0L to st)
        while (heap.isNotEmpty()) {
            val (dist, i) = heap.poll()
            if (visited[i] != dist)
                continue

            for ((j, w) in al[i]) {
                if (visited[j] > dist + w) {
                    visited[j] = dist + w
                    heap.offer(visited[j] to j)
                }
            }
        }
    }

    fun minimumWeight(n: Int, edges: Array<IntArray>, src1: Int, src2: Int, dest: Int): Long {
        val al = Array(n) { mutableListOf<Pair<Int, Int>>() }
        val ral = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for ((a, b, w) in edges) {
            al[a].add(b to w)
            ral[b].add(a to w)
        }

        val dd = LongArray(n) { Long.MAX_VALUE }
        dd[dest] = 0
        val s1d = LongArray(n) { Long.MAX_VALUE }
        s1d[src1] = 0
        val s2d = LongArray(n) { Long.MAX_VALUE }
        s2d[src2] = 0

        bfs(dest, ral, dd)
        bfs(src1, al, s1d)
        bfs(src2, al, s2d)

        if (dd[src1] == Long.MAX_VALUE || dd[src2] == Long.MAX_VALUE)
            return -1

        return (0 until n).map {
            if (dd[it] != Long.MAX_VALUE && s1d[it] != Long.MAX_VALUE && s2d[it] != Long.MAX_VALUE)
                dd[it] + s1d[it] + s2d[it]
            else
                Long.MAX_VALUE
        }.minOrNull()!!
    }
}

fun main() {
    println(Solution2203().minimumWeight(
        6,
        arrayOf(intArrayOf(0,2,2),intArrayOf(0,5,6),intArrayOf(1,0,3),intArrayOf(1,4,5),intArrayOf(2,1,1),intArrayOf(2,3,3),intArrayOf(2,3,4),intArrayOf(3,4,2),intArrayOf(4,5,1)),
        0,
        1,
        5
    ))
}