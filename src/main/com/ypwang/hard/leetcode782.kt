package com.ypwang.hard

class Solution782 {
    fun movesToChessboard(board: Array<IntArray>): Int {
        val size = board.size
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (board[0][0] xor board[i][0] xor board[0][j] xor board[i][j] == 1) return -1
            }
        }

        var rowSwap = 0
        var colSwap = 0
        var rowCount = 0
        var colCount = 0

        for (i in 0 until size) {
            rowSwap += if (board[i][0] == (i % 2)) 1 else 0
            colSwap += if (board[0][i] == (i % 2)) 1 else 0
            rowCount += board[i][0]
            colCount += board[0][i]
        }

        if (rowCount != size / 2 && rowCount != (size+1) / 2) return -1
        if (colCount != size / 2 && colCount != (size+1) / 2) return -1

        return when (size % 2) {
            0 -> (minOf(rowSwap, size - rowSwap) + minOf(colSwap, size - colSwap)) / 2
            1 -> (rowSwap.let { if (it % 2 == 0) it else size - it } + colSwap.let { if (it % 2 == 0) it else size - it }) / 2
            else -> throw Exception("stupid kotlin")
        }
    }
}