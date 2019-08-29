package com.ypwang.hard

class Solution37 {
    fun solveSudoku(board: Array<CharArray>) {
        fun dfs(i: Int, j: Int): Boolean {
            if (i == 9)
                return true

            val (ni, nj) = if (j < 8) i to j+1 else i+1 to 0
            if (board[i][j] == '.') {
                val set = (1..9).map { '0' + it }.toMutableSet()

                val chunkX = (i / 3) * 3
                val chunkY = (j / 3) * 3

                for (m in 0 until 9) {
                    set.remove(board[m][j])
                    set.remove(board[i][m])
                    set.remove(board[chunkX+m/3][chunkY+m%3])
                }

                if (set.isNotEmpty()) {
                    for (c in set) {
                        board[i][j] = c
                        if (dfs(ni, nj)) return true
                    }
                }

                board[i][j] = '.'
                return false
            }
            return dfs(ni, nj)
        }

        dfs(0, 0)
    }
}

fun main() {
    val board = arrayOf(
            charArrayOf('.','.','9','7','4','8','.','.','.'),charArrayOf('7','.','.','.','.','.','.','.','.'),charArrayOf('.','2','.','1','.','9','.','.','.'),charArrayOf('.','.','7','.','.','.','2','4','.'),charArrayOf('.','6','4','.','1','.','5','9','.'),charArrayOf('.','9','8','.','.','.','3','.','.'),charArrayOf('.','.','.','8','.','3','.','2','.'),charArrayOf('.','.','.','.','.','.','.','.','6'),charArrayOf('.','.','.','2','7','5','9','.','.')
    )

    Solution37().solveSudoku(board)
    println(board.map { it.joinToString("") })
}