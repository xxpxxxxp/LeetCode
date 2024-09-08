package com.ypwang.hard

class Solution3283 {
    fun maxMoves(kx: Int, ky: Int, positions: Array<IntArray>): Int {
        val dist = Array(2500) { IntArray(2500) { 0 } }
        val done = BooleanArray(2500) { false }
        val m = 50
        val n = 50
        val newPos = Array<IntArray>(positions.size + 1) {
            if (it == 0) intArrayOf(kx, ky)
            else positions[it-1]
        }

        for ((i, j) in newPos) {
            val source = n * i + j
            if (done[source])
                continue

            val q = ArrayDeque<Triple<Int, Int, Int>>()
            q.add(Triple(i, j, 0))
            val v = Array(m) { BooleanArray(n) { false } }
            v[i][j] = true

            while (q.isNotEmpty()) {
                val (ii, jj, d) = q.removeLast()
                dist[source][n * ii + jj] = d

                for (dx in -2..2) {
                    for (dy in -2..2) {
                        if (Math.abs(dx) == Math.abs(dy))
                            continue
                        val x = ii + dx
                        val y = jj + dy
                        if (x >= 0 && x < m && y >= 0 && y < n && !v[x][y]) {
                            v[x][y] = true
                            q.addFirst(Triple(x, y, d + 1))
                        }
                    }
                }
            }

            done[source] = true
        }

        val nPositions = newPos.size
        val target = (1 shl nPositions) - 1
        val dp = Array(nPositions) { Array(1 shl nPositions) { IntArray(2) { -1 } } }

        for (i in 0 until nPositions) {
            dp[i][target][0] = 0
            dp[i][target][1] = 0
        }

        for (mask in target - 1 downTo 0) {
            for (curr in 0 until nPositions) {
                for (alice in 0..1) {
                    dp[curr][mask][alice] = if (alice == 1) Int.MIN_VALUE else Int.MAX_VALUE

                    for (i in 0 until nPositions - 1) {
                        if (mask and (1 shl i) == 0) {
                            val cost = dist[n * newPos[curr][0] + newPos[curr][1]][n * newPos[i][0] + newPos[i][1]]
                            if (alice == 1) {
                                dp[curr][mask][alice] = maxOf(dp[curr][mask][alice], cost + dp[i][mask or (1 shl i)][1 - alice])
                            } else {
                                dp[curr][mask][alice] = minOf(dp[curr][mask][alice], cost + dp[i][mask or (1 shl i)][1 - alice])
                            }
                        }
                    }
                }
            }
        }

        return dp[nPositions - 1][1 shl (nPositions - 1)][1]
    }
}
