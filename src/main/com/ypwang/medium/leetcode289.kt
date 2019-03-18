package com.ypwang.medium

class Solution289 {
    fun gameOfLife(board: Array<IntArray>): Unit {
        if (board.isEmpty()) {
            return
        }

        val neighbors = listOf(-1 to -1, -1 to 0, -1 to 1, 0 to 1, 1 to 1, 1 to 0, 1 to -1, 0 to -1)

        val x = board[0].size
        val y = board.size

        for (i in 0 until x) {
            for (j in 0 until y) {
                val n = neighbors
                    .filter { i + it.first in 0 until x && j + it.second in 0 until y }
                    .count { board[j + it.second][i + it.first] and 0xF == 1 }

                if (board[j][i] and 0xF == 1) {
                    when (n) {
                       in 2..3 -> board[j][i] = board[j][i] or 0x10
                       else -> {}
                    }
                } else {
                    if (n == 3) {
                        board[j][i] = board[j][i] or 0x10
                    }
                }
            }
        }

        for (i in 0 until x) {
            for (j in 0 until y) {
                board[j][i] = board[j][i] shr 4
            }
        }
    }
}