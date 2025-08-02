package com.ypwang.medium

import java.util.*

class Solution3603 {
    fun minCost(m: Int, n: Int, waitCost: Array<IntArray>): Long {
        val pq =
            PriorityQueue<LongArray>(compareBy { it[0] })
        pq.offer(longArrayOf(1, 0, 0))

        val costMatrix = Array(m) { LongArray(n) { Long.Companion.MAX_VALUE } }
        costMatrix[0][0] = 1

        while (pq.isNotEmpty()) {
            val (cost, a, b) = pq.poll()
            val x = a.toInt()
            val y = b.toInt()

            if (cost > costMatrix[x][y])
                continue

            if (x == m - 1 && y == n - 1)
                return cost - waitCost[0][0]

            var nx = x + 1
            var ny = y
            if (nx < m) {
                val newCost = cost + waitCost[x][y] + (nx + 1L) * (ny + 1L)
                if (costMatrix[nx][ny] > newCost) {
                    costMatrix[nx][ny] = newCost
                    pq.offer(longArrayOf(newCost, nx.toLong(), ny.toLong()))
                }
            }

            nx = x
            ny = y + 1
            if (ny < n) {
                val newCost = cost + waitCost[x][y] + (nx + 1L) * (ny + 1L)
                if (costMatrix[nx][ny] > newCost) {
                    costMatrix[nx][ny] = newCost
                    pq.offer(longArrayOf(newCost, nx.toLong(), ny.toLong()))
                }
            }
        }

        return -1
    }
}
