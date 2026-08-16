package com.ypwang.hard

class Solution4023 {
    fun elevatorRequests(n: Int, start: Int, requests: IntArray): Long {
        val a = requests.filter { it != start }.sorted().toIntArray()
        val m = a.size

        if (m == 0)
            return 0L

        val size = m * m
        val INF = Long.MAX_VALUE / 4

        val dpL = LongArray(size) { INF }
        val dpR = LongArray(size) { INF }

        for (i in 0 until m) {
            val cost = Math.abs(start.toLong() - a[i]) * m
            val pos = i * m + i

            dpL[pos] = cost
            dpR[pos] = cost
        }

        for (len in 1 until m) {
            val remaining = m - len

            var l = 0
            while (l + len - 1 < m) {
                val r = l + len - 1
                val pos = l * m + r

                val leftCost = dpL[pos]
                val rightCost = dpR[pos]

                if (r + 1 < m) {
                    val nr = r + 1
                    val nextPos = l * m + nr

                    if (leftCost != INF)
                        dpR[nextPos] = minOf(dpR[nextPos], leftCost + Math.abs(a[l].toLong() - a[nr]) * remaining)

                    if (rightCost != INF)
                        dpR[nextPos] = minOf(dpR[nextPos], rightCost + Math.abs(a[r].toLong() - a[nr]) * remaining)
                }

                if (l - 1 >= 0) {
                    val nl = l - 1
                    val nextPos = nl * m + r

                    if (leftCost != INF)
                        dpL[nextPos] = minOf(dpL[nextPos], leftCost + Math.abs(a[l].toLong() - a[nl]) * remaining)

                    if (rightCost != INF)
                        dpL[nextPos] = minOf(dpL[nextPos], rightCost + Math.abs(a[r].toLong() - a[nl]) * remaining)
                }

                l++
            }
        }

        val finalPos = m - 1
        return minOf(dpL[finalPos], dpR[finalPos])
    }
}

fun main() {
    println(Solution4023().elevatorRequests(6, 4, intArrayOf(1, 5)))
}
