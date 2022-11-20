package com.ypwang.medium

class Solution2477 {
    fun minimumFuelCost(roads: Array<IntArray>, seats: Int): Long {
        val connections = Array(roads.size + 1) { mutableListOf<Int>() }
        for ((a, b) in roads) {
            connections[a].add(b)
            connections[b].add(a)
        }

        // return: how many people now, how many fuel used
        fun dfs(cur: Int, from: Int): Pair<Int, Long> {
            var people = 1
            var fuel = 0L

            for (n in connections[cur]) {
                if (n != from) {
                    val (p, f) = dfs(n, cur)
                    people += p
                    fuel += f
                }
            }

            // go to next
            if (cur != 0)
                fuel += (people + seats - 1) / seats
            return people to fuel
        }

        return dfs(0, -1).second
    }
}

fun main() {
    println(Solution2477().minimumFuelCost(
        arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(0,3)), 5
    ))
}