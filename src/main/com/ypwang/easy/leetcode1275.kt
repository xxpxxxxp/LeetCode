package com.ypwang.easy

import java.lang.Exception

class Solution1275 {
    fun tictactoe(moves: Array<IntArray>): String {
        val board = Array(3){ IntArray(3) }

        var isA = true
        for ((x, y) in moves) {
            when (isA) {
                true -> board[x][y] = 1
                false -> board[x][y] = 2
            }
            isA = !isA
        }

        fun winner(w: Int): String =
                when(w) {
                    1 -> "A"
                    2 -> "B"
                    else -> throw Exception()
                }

        for (i in 0 until 3) {
            if (board[i].groupBy { it }.let { it.size == 1 && it.keys.first() > 0 })
                return winner(board[i][0])

            if (board.map { it[i] }.groupBy { it }.let { it.size == 1 && it.keys.first() > 0 })
                return winner(board[0][i])
        }

        if ((0 until 3).map { board[it][it] }.groupBy { it }.let { it.size == 1 && it.keys.first() > 0 })
            return winner(board[0][0])

        if ((0 until 3).map { board[it][2-it] }.groupBy { it }.let { it.size == 1 && it.keys.first() > 0 })
            return winner(board[0][2])

        return if (moves.size == 9) "Draw" else "Pending"
    }
}