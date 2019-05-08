package com.ypwang.easy

class Solution999 {
    fun numRookCaptures(board: Array<CharArray>): Int {
        var r = 0
        var c = 0

        for (i in 0 until 8) {
            for (j in 0 until 8) {
                if (board[i][j] == 'R') {
                    r = i
                    c = j
                }
            }
        }

        var count = 0
        var r1 = r - 1
        label@ while (r1 >= 0) {
            when (board[r1][c]) {
                'B' -> break@label
                'p' -> {
                    count++
                    break@label
                }
                else -> {}
            }
            r1--
        }

        r1 = r + 1
        label@ while (r1 < 8) {
            when (board[r1][c]) {
                'B' -> break@label
                'p' -> {
                    count++
                    break@label
                }
                else -> {}
            }
            r1++
        }

        var c1 = c - 1
        label@ while (c1 >= 0) {
            when (board[r][c1]) {
                'B' -> break@label
                'p' -> {
                    count++
                    break@label
                }
                else -> {}
            }
            c1--
        }

        c1 = c + 1
        label@ while (c1 < 8) {
            when (board[r][c1]) {
                'B' -> break@label
                'p' -> {
                    count++
                    break@label
                }
                else -> {}
            }
            c1++
        }

        return count
    }
}