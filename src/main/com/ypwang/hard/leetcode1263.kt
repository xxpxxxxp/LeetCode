package com.ypwang.hard

import java.util.PriorityQueue

class Solution1263 {
    fun minPushBox(grid: Array<CharArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val target = IntArray(2)
        val start = IntArray(2)
        val person = IntArray(2)

        for (i in 0 until m) {
            for (j in 0 until n) {
                when (grid[i][j]) {
                    'T' -> {
                        target[0] = i
                        target[1] = j
                    }
                    'B' -> {
                        start[0] = i
                        start[1] = j
                    }
                    'S' -> {
                        person[0] = i
                        person[1] = j
                    }
                }
            }
        }

        fun h(box: IntArray): Int = Math.abs(target[0] - box[0]) + Math.abs(target[1] - box[1])
        fun out(pos: IntArray): Boolean =
                pos[0] !in 0 until m || pos[1] !in 0 until n || grid[pos[0]][pos[1]] == '#'

        val visited = mutableSetOf<Int>()

        val heap = PriorityQueue<kotlin.Pair<Int, Triple<Int, IntArray, IntArray>>>(Comparator { a, b -> a.first.compareTo(b.first) })
        heap.offer(h(start) to Triple(0, person, start))

        while (heap.isNotEmpty()) {
            val (_, t) = heap.poll()
            val (move, p, b) = t
            if (b.contentEquals(target)) return move
            val hash = (p[0] shl 15) + (p[1] shl 10) + (b[0] shl 5) + b[1]
            if (hash in visited) continue
            visited.add(hash)

            for ((dx, dy) in listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)) {
                val np = intArrayOf(p[0] + dx, p[1] + dy)
                if (out(np)) continue
                if (np.contentEquals(b)) {
                    val nb = intArrayOf(b[0] + dx, b[1] + dy)
                    if (out(nb)) continue
                    heap.offer(h(nb) + move + 1 to Triple(move + 1, np, nb))
                } else
                    heap.offer(h(b) + move to Triple(move, np, b))
            }
        }

        return -1
    }
}