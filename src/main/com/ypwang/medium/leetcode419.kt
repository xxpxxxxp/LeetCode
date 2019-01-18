package com.ypwang.medium

class Solution419 {
    fun countBattleships(board: Array<CharArray>): Int {
        var rst = 0
        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) {
                if (board[i][j] == 'X' && (i == 0 || board[i-1][j] != 'X') && (j == 0 || board[i][j-1] != 'X')) {
                    rst++
                }
            }
        }
        return rst
    }
}