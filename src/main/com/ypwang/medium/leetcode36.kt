package com.ypwang.medium

class Solution36 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val horizontal = Array<MutableSet<Char>>(9){ mutableSetOf() }
        val vertical = Array<MutableSet<Char>>(9){ mutableSetOf() }
        val grid = Array<MutableSet<Char>>(9){ mutableSetOf() }

        for ((i, line) in board.withIndex()) {
            for ((j, e) in line.withIndex()) {
                if (e == '.')
                    continue

                val hor = horizontal[i]
                val ver = vertical[j]
                val gri = grid[(i/3)*3 + j/3]

                if (e in hor || e in ver || e in  gri)
                    return false

                hor.add(e)
                ver.add(e)
                gri.add(e)
            }
        }

        return true
    }
}

fun main() {
    println(Solution36().isValidSudoku(
            arrayOf(charArrayOf('5','3','.','.','7','.','.','.','.'),charArrayOf('6','.','.','1','9','5','.','.','.'),charArrayOf('.','9','8','.','.','.','.','6','.'),charArrayOf('8','.','.','.','6','.','.','.','3'),charArrayOf('4','.','.','8','.','3','.','.','1'),charArrayOf('7','.','.','.','2','.','.','.','6'),charArrayOf('.','6','.','.','.','.','2','8','.'),charArrayOf('.','.','.','4','1','9','.','.','5'),charArrayOf('.','.','.','.','8','.','.','7','9'))
    ))
}