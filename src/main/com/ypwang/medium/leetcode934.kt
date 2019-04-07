package com.ypwang.medium

import java.util.*

class Solution934 {
    fun shortestBridge(A: Array<IntArray>): Int {
        val m = A.size
        val n = A[0].size

        var i = 0
        while (true) {
            if (A[i / n][i % n] == 1) {
                break
            }
            i++
        }

        val island = mutableSetOf<Int>()
        val queue: Queue<Int> = LinkedList<Int>()
        queue.offer(i)

        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            if (cur in island) {
                continue
            }
            island.add(cur)
            val x = cur % n
            val y = cur / n

            if (x > 0 && A[y][x-1] == 1) {
                queue.add(y * n + x - 1)
            }
            if (x < n - 1 && A[y][x+1] == 1) {
                queue.add(y * n + x + 1)
            }
            if (y > 0 && A[y-1][x] == 1) {
                queue.add(y * n + x - n)
            }
            if (y < m - 1 && A[y+1][x] == 1) {
                queue.add(y * n + x + n)
            }
        }

        var count = 0
        var grow = island.toList()

        while (grow.isNotEmpty()) {
            val next = mutableListOf<Int>()
            for (point in grow) {
                val x = point % n
                val y = point / n

                if (x > 0) {
                    if (A[y][x-1] == 0) {
                        A[y][x-1] = 1
                        island.add(y * n + x - 1)
                        next.add(y * n + x - 1)
                    } else if ((y * n + x - 1) !in island)
                        return count
                }
                if (x < n - 1) {
                    if (A[y][x+1] == 0) {
                        A[y][x+1] = 1
                        island.add(y * n + x + 1)
                        next.add(y * n + x + 1)
                    } else if ((y * n + x + 1) !in island)
                        return count
                }
                if (y > 0) {
                    if (A[y-1][x] == 0) {
                        A[y-1][x] = 1
                        island.add(y * n + x - n)
                        next.add(y * n + x - n)
                    } else if ((y * n + x - n) !in island)
                        return count
                }
                if (y < m - 1) {
                    if (A[y+1][x] == 0) {
                        A[y+1][x] = 1
                        island.add(y * n + x + n)
                        next.add(y * n + x + n)
                    } else if ((y * n + x + n) !in island)
                        return count
                }
            }
            count++
            grow = next
        }

        return 0
    }
}

fun main() {
    println(Solution934().shortestBridge(arrayOf(
            intArrayOf(1,1,1,1,1), intArrayOf(1,0,0,0,1), intArrayOf(1,0,1,0,1), intArrayOf(1,0,0,0,1), intArrayOf(1,1,1,1,1)
    )))
}