package com.ypwang.medium

import java.util.PriorityQueue

class Solution3341 {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val m = moveTime.size
        val n = moveTime[0].size
        val seen = Array(m) { IntArray(n) { Int.MAX_VALUE } }
        seen[0][0] = 0
        val heap = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third })
        heap.add(Triple(0, 0, 0))

        while (heap.isNotEmpty()) {
            val (x, y, time) = heap.poll()
            if (x == m-1 && y == n-1)
                return time

            for ((dx, dy) in listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)) {
                val nx = x + dx
                val ny = y + dy
                if (nx in 0 until m && ny in 0 until n) {
                    val nt = maxOf(time+1, moveTime[nx][ny]+1)
                    if (nt < seen[nx][ny]) {
                        seen[nx][ny] = nt
                        heap.offer(Triple(nx, ny, nt))
                    }
                }
            }
        }

        return -1
    }
}

fun main() {
    println(Solution3341().minTimeToReach(arrayOf(
        intArrayOf(0, 4), intArrayOf(4, 4)
    )))
}