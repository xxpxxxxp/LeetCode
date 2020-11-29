package com.ypwang.medium

class Solution79 {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        if (word.isEmpty()) return true
        if (board.isEmpty() || board[0].isEmpty()) return false

        val w = word.toCharArray()

        val m = board.size
        val n = board[0].size

        val indicator = Array(m){ Array(n){false} }
        fun helper(index: Pair<Int, Int>, pos: Int): Boolean {
            if (pos == w.size)
                return true

            indicator[index.first][index.second] = true
            val cur = w[pos]

            // go right
            if (index.second < n - 1 && !indicator[index.first][index.second+1] && board[index.first][index.second+1] == cur) {
                if (helper(Pair(index.first, index.second+1), pos+1)) return true
            }

            // go down
            if (index.first < m - 1 && !indicator[index.first+1][index.second] && board[index.first+1][index.second] == cur) {
                if (helper(Pair(index.first+1, index.second), pos+1)) return true
            }

            // go left
            if (index.second > 0 && !indicator[index.first][index.second-1] && board[index.first][index.second-1] == cur) {
                if (helper(Pair(index.first, index.second-1), pos+1)) return true
            }

            // go up
            if (index.first > 0 && !indicator[index.first-1][index.second] && board[index.first-1][index.second] == cur) {
                if (helper(Pair(index.first-1, index.second), pos+1)) return true
            }

            indicator[index.first][index.second] = false
            return false
        }

        for ((i, line) in board.withIndex()) {
            for ((j, c) in line.withIndex()) {
                if (c == w.first()) {
                    if (helper(Pair(i, j), 1))
                        return true
                }
            }
        }

        return false
    }
}

fun main() {
    println(Solution79().exist(
            arrayOf(charArrayOf('A','B','C','E'),
                    charArrayOf('S','F','E','S'),
                    charArrayOf('A','D','E','E')), "ABCESEEEFS"
    ))
}