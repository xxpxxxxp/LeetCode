package com.ypwang.medium

import java.util.PriorityQueue

class Solution3342 {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val m = moveTime.size
        val n = moveTime[0].size
        // 0 -> R, 1 -> C, 2 -> Cost to Reach that Room, 3 -> First or Second Move
        val heap = PriorityQueue<IntArray>(compareBy { it[2] })
        heap.add(intArrayOf(0, 0, 0, 1))

        val dp = Array(m) { IntArray(n) { Int.MAX_VALUE } }
        dp[0][0] = 0

        while (heap.isNotEmpty()) {
            val (r, c, t, add) = heap.poll()
            for ((dx, dy) in listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)) {
                val nr = r + dx
                val nc = c + dy
                if (nr in 0 until m && nc in 0 until n) {
                    val cost = maxOf(moveTime[nr][nc], t) + add
                    if (nr == m - 1 && nc == n - 1)
                        return cost

                    if (cost < dp[nr][nc]) {
                        dp[nr][nc] = cost
                        heap.add(intArrayOf(nr, nc, cost, if (add == 1) 2 else 1))
                    }
                }
            }
        }

        return -1
    }
}
