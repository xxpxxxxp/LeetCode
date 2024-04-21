package com.ypwang.hard

import java.util.*

class Solution3123 {
    fun findAnswer(n: Int, edges: Array<IntArray>): BooleanArray {
        val conn = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for ((i, arr) in edges.withIndex()) {
            conn[arr[0]].add(arr[1] to i)
            conn[arr[1]].add(arr[0] to i)
        }

        val weights = IntArray(n) { Int.MAX_VALUE }
        val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        heap.offer(0 to 0)
        while (heap.isNotEmpty()) {
            val (node, w) = heap.poll()
            if (w < weights[node]) {
                weights[node] = w

                for ((next, i) in conn[node])
                    heap.offer(next to w + edges[i][2])
            }
        }

        val rst = BooleanArray(edges.size)
        val queue = LinkedList<Int>()
        queue.add(n-1)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            for ((next, i) in conn[node])
                if (weights[node] - weights[next] == edges[i][2]) {
                    rst[i] = true
                    queue.offer(next)
                }
        }

        return rst
    }
}

fun main() {
    println(Solution3123().findAnswer(6, arrayOf(
        intArrayOf(0,1,4),
        intArrayOf(0,2,1),
        intArrayOf(1,3,2),
        intArrayOf(1,4,3),
        intArrayOf(1,5,1),
        intArrayOf(2,3,1),
        intArrayOf(3,5,3),
        intArrayOf(4,5,2)
    )).toList())
}