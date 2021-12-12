package com.ypwang.medium

import java.util.*

class Solution2101 {
    fun maximumDetonation(bombs: Array<IntArray>): Int {
        fun bfs(i: Int): Int {
            val seen = mutableSetOf(i)
            val queue: Queue<Int> = LinkedList()
            queue.add(i)

            while (queue.isNotEmpty()) {
                val (x, y, r) = bombs[queue.poll()]
                for (j in bombs.indices) {
                    if (j !in seen) {
                        val (m, n) = bombs[j]
                        if ((x.toLong()-m)*(x-m) + (y.toLong()-n)*(y-n) <= r.toLong()*r) {
                            queue.offer(j)
                            seen.add(j)
                        }
                    }
                }
            }

            return seen.size
        }

        return bombs.indices.map { bfs(it) }.maxOrNull()!!
    }
}