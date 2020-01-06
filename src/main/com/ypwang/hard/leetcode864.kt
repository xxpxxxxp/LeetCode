package com.ypwang.hard

class Solution864 {
    fun shortestPathAllKeys(grid: Array<String>): Int {
        val m = grid.size
        val n = grid[0].length

        var p = -1
        var q = -1
        var cnt = 0

        label@ for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == '@') {
                    p = i
                    q = j
                }
                if (grid[i][j] in 'a'..'f') cnt++
            }
        }

        val dest = (1 shl cnt) - 1
        var queue = setOf((p shl 5) + q)
        val seen = mutableSetOf<Int>()

        var step = 0
        while (queue.isNotEmpty()) {
            seen.addAll(queue)
            val next = mutableSetOf<Int>()

            for (hash in queue) {
                val key = hash shr 10
                val x = (hash shr 5) and 0x1f
                val y = hash and 0x1f

                if (key == dest) return step

                for ((dx, dy) in listOf(-1 to 0, 0 to -1, 1 to 0, 0 to 1)) {
                    val nx = x + dx
                    val ny = y + dy
                    if (nx in 0 until m && ny in 0 until n) {
                        when (grid[nx][ny]) {
                            '#' -> {} // no go
                            '.', '@' -> {
                                val nhash = (key shl 10) + (nx shl 5) + ny
                                if (nhash !in seen) next.add(nhash)
                            }
                            in 'a'..'f' -> {
                                val nhash = ((key or (1 shl grid[nx][ny]-'a')) shl 10) + (nx shl 5) + ny
                                if (nhash !in seen) next.add(nhash)
                            }
                            in 'A'..'F' ->
                                if (key and (1 shl grid[nx][ny]-'A') != 0) {
                                    val nhash = (key shl 10) + (nx shl 5) + ny
                                    if (nhash !in seen) next.add(nhash)
                                }
                        }
                    }
                }
            }

            step++
            queue = next
        }

        return -1
    }
}

fun main() {
    println(Solution864().shortestPathAllKeys(arrayOf("@...a",".###A","b.BCc")))
    println(Solution864().shortestPathAllKeys(arrayOf("@.a.#","###.#","b.A.B")))
    println(Solution864().shortestPathAllKeys(arrayOf("@..aA","..B#.","....b")))
}