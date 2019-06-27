package com.ypwang.hard

import java.util.*

class Solution1036 {
    fun isEscapePossible(blocked: Array<IntArray>, source: IntArray, target: IntArray): Boolean {
        val blocks = blocked.map { it[0] to it[1] }.toSet()

        val move = arrayOf(-1 to 0, 1 to 0, 0 to 1, 0 to -1)
        fun bfs(start: Pair<Int, Int>, end: Pair<Int, Int>): Boolean {
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            queue.add(start)
            val seen = mutableSetOf(start)

            var count = 0
            while (queue.isNotEmpty() && count++ < 20000) {
                val cur = queue.poll()

                for (m in move) {
                    val n = cur.first + m.first to cur.second + m.second

                    if (n == end)
                        return true
                    if (n.first in 0..1000000 && n.second in 0..1000000 && n !in blocks && n !in seen) {
                        queue.offer(n)
                        seen.add(n)
                    }
                }
            }

            return queue.isNotEmpty()
        }

        return bfs(source[0] to source[1], target[0] to target[1]) && bfs(target[0] to target[1], source[0] to source[1])
    }
}

fun main() {
    println(Solution1036().isEscapePossible(arrayOf(intArrayOf(0,1), intArrayOf(1,0)), intArrayOf(0,0), intArrayOf(0,2)))
}