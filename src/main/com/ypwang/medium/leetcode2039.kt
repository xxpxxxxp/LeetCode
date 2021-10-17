package com.ypwang.medium

import java.util.*

class Solution2039 {
    fun networkBecomesIdle(edges: Array<IntArray>, patience: IntArray): Int {
        val connection = mutableMapOf<Int, MutableList<Int>>()
        for ((a, b)  in edges) {
            connection.getOrPut(a) { mutableListOf() }.add(b)
            connection.getOrPut(b) { mutableListOf() }.add(a)
        }

        val dis = IntArray(patience.size) { Int.MAX_VALUE }
        dis[0] = 0
        val queue: Queue<Int> = LinkedList()
        queue.add(0)
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            val d = dis[cur] + 1
            for (n in connection.getOrDefault(cur, mutableListOf())) {
                if (dis[n] > d) {
                    dis[n] = d
                    queue.add(n)
                }
            }
        }
        
        return dis.zip(patience).map { (d, p) ->
            if (p == 0) 0 else 1 + 2 * d + (2 * d - 1) / p * p
        }.max()!!
    }
}

fun main() {
    println(Solution2039().networkBecomesIdle(
        arrayOf(intArrayOf(0,1), intArrayOf(1,2)), intArrayOf(0,2,1)
    ))
}