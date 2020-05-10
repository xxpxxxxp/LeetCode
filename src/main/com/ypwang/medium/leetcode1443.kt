package com.ypwang.medium

class Solution1443 {
    fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
        val to = Array(n){ mutableListOf<Int>() }

        for ((a, b) in edges) {
            to[a].add(b)
            to[b].add(a)
        }

        // return: steps to hasApple
        fun steps(cur: Int, from: Int): Pair<Int, Boolean> {
            var count = 0
            var apple = hasApple[cur]

            for (i in to[cur]) {
                if (i == from) continue
                val (next, h) = steps(i, cur)
                if (h) {
                    count += next + 2
                    apple = true
                }
            }

            return count to apple
        }

        return steps(0, -1).first
    }
}

fun main() {
    println(Solution1443().minTime(7, arrayOf(
            intArrayOf(0,1), intArrayOf(0,2), intArrayOf(1,4), intArrayOf(1,5), intArrayOf(2,3), intArrayOf(2,6)
    ), listOf(false, false, true, false, true, true, false)))
}