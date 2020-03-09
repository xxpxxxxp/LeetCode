package com.ypwang.hard

class Solution1368 {
    private val diff = arrayOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

    fun minCost(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val seen = mutableSetOf<Int>()
        var queue = mutableSetOf(0)
        var step = 0

        while (true) {
            // path chain for all node in current step
            val chain = mutableSetOf<Int>()
            for (cur in queue) {
                var x = cur shr 8
                var y = cur and 0xff

                while (x in 0 until m && y in 0 until n) {
                    if (x == m-1 && y == n-1) return step

                    val bit = (x shl 8) or y
                    if (bit in seen || !chain.add(bit)) break
                    when (grid[x][y]) {
                        1 -> y++
                        2 -> y--
                        3 -> x++
                        4 -> x--
                    }
                }
            }

            // current step checked
            seen.addAll(chain)

            // generate next step
            val next = mutableSetOf<Int>()
            for (cur in chain) {
                val x = cur shr 8
                val y = cur and 0xff

                for (i in 0 until 4) {
                    if (i + 1 != grid[x][y]) {
                        val dx = x + diff[i].first
                        val dy = y + diff[i].second

                        if (dx in 0 until m && dy in 0 until n) {
                            val bit = (dx shl 8) or dy
                            if (bit !in seen)
                                next.add(bit)
                        }
                    }
                }
            }

            queue = next
            step++
        }
    }
}

fun main() {
    println(Solution1368().minCost(arrayOf(
            intArrayOf(1,1,1,1), intArrayOf(2,2,2,2), intArrayOf(1,1,1,1), intArrayOf(2,2,2,2)
    )))
    println(Solution1368().minCost(arrayOf(
            intArrayOf(1,1,3), intArrayOf(3,2,2), intArrayOf(1,1,4)
    )))
    println(Solution1368().minCost(arrayOf(
            intArrayOf(1,2), intArrayOf(4,3)
    )))
    println(Solution1368().minCost(arrayOf(
            intArrayOf(2,2,2), intArrayOf(2,2,2)
    )))
    println(Solution1368().minCost(arrayOf(
            intArrayOf(4)
    )))
}