package com.ypwang.medium

import java.util.Deque
import java.util.LinkedList

class Solution3419 {
    fun minMaxWeight(n: Int, edges: Array<IntArray>, threshold: Int): Int {
        val rev = MutableList(n) { mutableListOf<Int>() }

        val weightSet = mutableSetOf<Int>()
        for ((u, v, w) in edges) {
            rev[v].add(u)
            weightSet.add(w)
        }

        if (!canVisitAll(n, rev))
            return -1

        val weights = weightSet.toList().sorted()

        var left = 0
        var right = weights.size - 1
        var ans = -1

        while (left <= right) {
            val mid = (left + right) / 2
            val W = weights[mid]

            val temp = MutableList(n) { mutableListOf<Int>() }
            for (e in edges) {
                val u = e[0]
                val v = e[1]
                val w = e[2]
                if (w <= W) {
                    temp[v].add(u)
                }
            }

            if (canVisitAll(n, temp)) {
                ans = W
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return ans
    }

    private fun canVisitAll(n: Int, revGraph: List<List<Int>>): Boolean {
        val visited = BooleanArray(n)
        visited[0] = true
        var count = 1

        val queue: Deque<Int> = LinkedList()
        queue.offer(0)

        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            for (nxt in revGraph[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true
                    count++
                    queue.offer(nxt)
                }
            }
        }

        return count == n
    }
}
