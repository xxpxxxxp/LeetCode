package com.ypwang.hard

class Solution2508 {
    fun isPossible(n: Int, edges: List<List<Int>>): Boolean {
        val conn = Array(n) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            conn[a-1].add(b-1)
            conn[b-1].add(a-1)
        }

        val odds = conn.withIndex().filter { it.value.size % 2 == 1 }.map { it.index }

        if (odds.size == 2) {
            val (a, b) = odds
            return (conn[a] + conn[b]).toSet().size < n
        }
        if (odds.size == 4) {
            val (a, b, c, d) = odds
            return (b !in conn[a] && d !in conn[c]) ||
                    (c !in conn[a] && d !in conn[b]) ||
                    (d !in conn[a] && b !in conn[c])
        }

        return odds.isEmpty()
    }
}