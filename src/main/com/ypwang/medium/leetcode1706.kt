package com.ypwang.medium

class Solution1706 {
    fun findBall(grid: Array<IntArray>): IntArray {
        val filtered = grid.fold((grid[0].indices).map { it to it }) { mapping, level ->
            mapping.filter { (_, c) ->
                if (level[c] == 1) {
                    c < grid[0].lastIndex && level[c+1] == 1
                } else {
                    c > 0 && level[c-1] == -1
                }
            }.map { (m, c) ->
                m to c + level[c]
            }
        }.toMap()

        return (grid[0].indices).map { filtered.getOrDefault(it, -1) }.toIntArray()
    }
}

fun main() {
    println(Solution1706().findBall(
        arrayOf(
            intArrayOf(1,1,1,-1,-1),
            intArrayOf(1,1,1,-1,-1),
            intArrayOf(-1,-1,-1,1,1),
            intArrayOf(1,1,1,1,-1),
            intArrayOf(-1,-1,-1,-1,-1)
        )
    ).toList())
    println(Solution1706().findBall(
        arrayOf(
            intArrayOf(-1)
        )
    ).toList())
}