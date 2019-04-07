package com.ypwang.medium

class Solution130 {
    fun solve(board: Array<CharArray>) {
        if (board.isEmpty())
            return

        val m = board.size
        val n = board[0].size

        fun turn(i: Int, j: Int) {
            board[i][j] = 'Q'

            if (i > 1 && board[i-1][j] == 'O')
                turn(i - 1, j)

            if (i < m-1 && board[i+1][j] == 'O')
                turn(i + 1, j)

            if (j > 1 && board[i][j-1] == 'O')
                turn(i, j - 1)

            if (j < n-1 && board[i][j+1] == 'O')
                turn(i, j + 1)
        }

        for (j in 0 until n) {
            if (board[0][j] == 'O') {
                turn(0, j)
            }
            if (board[m-1][j] == 'O') {
                turn(m-1, j)
            }
        }

        for (i in 0 until m) {
            if (board[i][0] == 'O') {
                turn(i, 0)
            }
            if (board[i][n-1] == 'O') {
                turn(i, n-1)
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                board[i][j] = if (board[i][j] == 'Q') 'O' else 'X'
            }
        }
    }
}

fun main() {
    println(Solution130().solve(arrayOf(
            "XXXX".toCharArray(), "XOOX".toCharArray(), "XOXX".toCharArray(), "XXOX".toCharArray()
    )))
}