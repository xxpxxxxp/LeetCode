package com.ypwang.hard

import java.util.*

class Solution4003 {
    fun minCost(m: Int, n: Int, penalty: Array<IntArray>): Long {
        val d = LongArray(m * n * 2) { Long.MAX_VALUE / 2 }
        val q = PriorityQueue<LongArray>(compareBy { it[0] })
        q.offer(longArrayOf(1L, 0, 0, 0))
        val dirs = arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 0, 0), intArrayOf(0, -1, 1), intArrayOf(-1, 0, 1))

        while (q.isNotEmpty()) {
            val curr = q.poll()
            val w = curr[0]
            val i = curr[1].toInt()
            val j = curr[2].toInt()
            val p = curr[3].toInt()

            if (i == m - 1 && j == n - 1)
                return w
            if (w > d[(i * n + j) * 2 + p])
                continue

            val k = (i * n + j) * 2 + (p xor 1)
            if (w + penalty[i][j] < d[k]) {
                d[k] = w + penalty[i][j]
                q.offer(longArrayOf(w + penalty[i][j], i.toLong(), j.toLong(), (p xor 1).toLong()))
            }

            for ((dr, dc, rp) in dirs) {
                val x = i + dr
                val y = j + dc
                if (x in 0 until m && y in 0 until n) {
                    val w2 = w + (x + 1).toLong() * (y + 1) + (if (p == rp) 0 else penalty[i][j])
                    val nextK = (x * n + y) * 2 + (p xor 1)
                    if (w2 < d[nextK]) {
                        d[nextK] = w2
                        q.offer(longArrayOf(w2, x.toLong(), y.toLong(), (p xor 1).toLong()))
                    }
                }
            }
        }
        return -1
    }
}
