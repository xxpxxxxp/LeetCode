package com.ypwang.medium

class Solution1958 {
    fun checkMove(board: Array<CharArray>, rMove: Int, cMove: Int, color: Char): Boolean {
        val m = board.size
        val n = board[0].size

        for ((dx, dy) in listOf(-1 to -1, -1 to 0, -1 to 1, 0 to -1, 0 to 1, 1 to -1, 1 to 0, 1 to 1)) {
            var i = 1
            var middle = false

            while (true) {
                val x = rMove + i * dx
                val y = cMove + i * dy

                if (x !in 0 until m || y !in 0 until n || board[x][y] == '.')
                    break

                if (board[x][y] != color)
                    middle = true
                else if (middle)
                    return true
                else
                    break

                i++
            }
        }

        return false
    }
}