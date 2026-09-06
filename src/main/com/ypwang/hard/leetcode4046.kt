package com.ypwang.hard

import java.util.PriorityQueue

class Solution4046 {
    data class State(
        val cost: Int,
        val turns: Int,
        val r: Int,
        val c: Int,
        val prevDir: Int
    )

    fun minCost(grid: Array<IntArray>, k: Int): Int {
        val n = grid.size
        val m = grid[0].size

        val pq = PriorityQueue<State>(compareBy { it.cost })

        val INF = Int.MAX_VALUE

        val dist = Array(n) { Array(m) { Array(k + 1) { IntArray(5) { INF } } } }

        dist[0][0][0][4] = grid[0][0]
        pq.offer(State(grid[0][0], 0, 0, 0, 4))

        val dr = intArrayOf(-1, 0, 1, 0)
        val dc = intArrayOf(0, 1, 0, -1)

        while (pq.isNotEmpty()) {
            val (cost, turns, r, c, prevDir) = pq.poll()

            if (cost != dist[r][c][turns][prevDir])
                continue

            if (r == n - 1 && c == m - 1)
                return cost

            for (d in 0 until 4) {
                val nr = r + dr[d]
                val nc = c + dc[d]

                if (nr !in 0 until n || nc !in 0 until m)
                    continue

                var newTurns = turns
                if (prevDir != 4 && prevDir != d)
                    newTurns++

                if (newTurns > k)
                    continue

                val newCost = cost + grid[nr][nc]

                if (newCost < dist[nr][nc][newTurns][d]) {
                    dist[nr][nc][newTurns][d] = newCost
                    pq.offer(State(newCost, newTurns, nr, nc, d))
                }
            }
        }

        return -1
    }
}
