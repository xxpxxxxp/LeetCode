package com.ypwang.medium

class Solution909 {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val m = board.size

        // idx: 0 ~ N*N-1
        val jump = mutableMapOf<Int, Int>()
        for (i in 0 until m) {
            for (j in 0 until m) {
                if (board[i][j] != -1) {
                    val row = m - 1 - i
                    // (i, j) index is
                    val idx = row * m + if (row % 2 == 0) j else m - 1 - j

                    // point to
                    jump[idx] = board[i][j] - 1
                }
            }
        }

        val visited = mutableSetOf<Int>()
        var round = listOf(0)
        var count = 0

        while (m * m - 1 !in round) {
            if (round.isEmpty()) return -1
            val newRound = mutableListOf<Int>()

            for (idx in round) {
                for (j in idx+1..idx+6) {
                    if (j < m * m) {
                        newRound.add(jump.getOrDefault(j, j))
                    }
                }
            }

            visited.addAll(round)
            round = newRound.minus(visited)
            count++
        }

        return count
    }
}

fun main() {
    println(Solution909().snakesAndLadders(arrayOf(
        intArrayOf(-1,-1,16,6,-1),intArrayOf(-1,9,25,8,-1),intArrayOf(8,20,2,7,-1),intArrayOf(-1,-1,12,-1,-1),intArrayOf(-1,-1,-1,12,23)
    )))
}