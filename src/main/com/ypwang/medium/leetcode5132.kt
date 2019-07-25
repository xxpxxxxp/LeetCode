package com.ypwang.medium

import java.util.*

class Solution5132 {
    fun shortestAlternatingPaths(n: Int, red_edges: Array<IntArray>, blue_edges: Array<IntArray>): IntArray {
        val rst = Array(n){ IntArray(2){ Int.MAX_VALUE } }

        val red = red_edges.groupBy { it[0] }.mapValues { it.value.map { a -> a[1] } }
        val blue = blue_edges.groupBy { it[0] }.mapValues { it.value.map { a -> a[1] } }

        val queue: Queue<Triple<Int, Boolean, Int>> = LinkedList()     // idx, line is red, jump

        queue.add(Triple(0, true, 0))
        queue.add(Triple(0, false, 0))

        while (queue.isNotEmpty()) {
            val (idx, isRed, jump) = queue.poll()
            val cur = if (isRed) rst[idx][0] else rst[idx][1]

            if (cur <= jump) continue
            if (isRed) {
                rst[idx][0] = jump
                // add all blue jumps
                if (idx in blue) {
                    for (id in blue[idx]!!) {
                        queue.add(Triple(id, false, jump+1))
                    }
                }
            } else {
                rst[idx][1] = jump
                // add all red jumps
                if (idx in red) {
                    for (id in red[idx]!!) {
                        queue.add(Triple(id, true, jump+1))
                    }
                }
            }
        }

        return rst.map { it.min()!! }.map { if (it == Int.MAX_VALUE) -1 else it }.toIntArray()
    }
}

fun main() {
    println(Solution5132().shortestAlternatingPaths(3, arrayOf(intArrayOf(0,1), intArrayOf(1,2)), arrayOf()).toList())
    println(Solution5132().shortestAlternatingPaths(3, arrayOf(intArrayOf(0,1)), arrayOf(intArrayOf(2,1))).toList())
    println(Solution5132().shortestAlternatingPaths(3, arrayOf(intArrayOf(1,0)), arrayOf(intArrayOf(2,1))).toList())
    println(Solution5132().shortestAlternatingPaths(3, arrayOf(intArrayOf(0,1)), arrayOf(intArrayOf(1,2))).toList())
    println(Solution5132().shortestAlternatingPaths(3, arrayOf(intArrayOf(0,1), intArrayOf(0,2)), arrayOf(intArrayOf(1,0))).toList())
}