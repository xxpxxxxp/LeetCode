package com.ypwang.hard

import java.util.*

class Solution1210 {
    private fun idx(x: Int, y: Int, direction: Boolean) = (x shl 16) + (y shl 8) + if (direction) 0 else 1
    private fun reverse(composed: Int) = Triple(composed shr 16, (composed shr 8) and 0xff, composed and 0xff == 0)

    /* Direction:
        True to right
        False to down
     */
    fun minimumMoves(grid: Array<IntArray>): Int {
        val n = grid.size
        val seen = mutableSetOf<Int>(0)
        val queue = LinkedList<Int>()
        queue.add(0)

        val target = idx(n-1, n-2, true)

        var count = 0
        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val cur = queue.poll()
                if (cur == target) return count
                val (x, y, d) = reverse(cur)

                if (d) {
                    // move right
                    if (y+2 < n && grid[x][y+2] == 0) idx(x, y+1, true).let { if (it !in seen) { queue.add(it); seen.add(it) } }
                    if (x+1 < n && grid[x+1][y] == 0 && grid[x+1][y+1] == 0) {
                        // rotate clockwise
                        idx(x, y, false).let { if (it !in seen) { queue.add(it); seen.add(it) } }
                        // move down
                        idx(x+1, y, true).let { if (it !in seen) { queue.add(it); seen.add(it) } }
                    }
                } else {
                    // move down
                    if (x+2 < n && grid[x+2][y] == 0) idx(x+1, y, false).let { if (it !in seen) { queue.add(it); seen.add(it) } }
                    if (y+1 < n && grid[x][y+1] == 0 && grid[x+1][y+1] == 0) {
                        // rotate counterclockwise
                        idx(x, y, true).let { if (it !in seen) { queue.add(it); seen.add(it) } }
                        // move right
                        idx(x, y+1, false).let { if (it !in seen) { queue.add(it); seen.add(it) } }
                    }
                }
            }
            count++
        }

        return -1
    }
}

fun main() {
    println(Solution1210().minimumMoves(listOf("00000001000010010010","01001011000100000000","00000000000001100010","01000000000000010001","01001010000000001011","00000000000000010010","10000001001000110011","01000000001000000010","00000001000010110000","00001111000011000010","10001000000000000000","00000000100000000000","00000010000000000000","00101000000100000000","00000000001001100100","00000000000000000000","10000000000000000000","00000000001000000000","00000100110001000010","00100000000001000000")
            .map { it.map { c -> c - '0' }.toIntArray() }.toTypedArray()))
}