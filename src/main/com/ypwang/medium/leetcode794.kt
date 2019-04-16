package com.ypwang.medium

class Solution794 {
    fun validTicTacToe(board: Array<String>): Boolean {
        var init = 0
        var count = 0
        for (i in 0 until board.size) {
            for (j in 0 until board[0].length) {
                init = init or (when (board[i][j]) {
                    'X' -> 1
                    'O' -> 2
                    else -> 0
                } shl 2 * count++)
            }
        }

        if (init == 0)
            return true

        // let's use first bit 0 denote next step should be 'X', 1 denote next step should be 'O'
        val cache = mutableSetOf(-2147483648)

        fun valid(i: Int): Boolean {
            if (i == 0)
                return true
            if (i in cache) return false

            // check if somebody already win
            if (
                    ((i and 0x3) != 0 && (i and 0x3) == (i and 0xc shr 2) && (i and 0x3) == (i and 0x30 shr 4)) ||
                    ((i and 0xc0) != 0 &&(i and 0xc0) == (i and 0x300 shr 2) && (i and 0xc0) == (i and 0xc00 shr 4)) ||
                    ((i and 0x3000) != 0 &&(i and 0x3000) == (i and 0xc000 shr 2) && (i and 0x3000) == (i and 0x30000 shr 4)) ||
                    ((i and 0x3) != 0 &&(i and 0x3) == (i and 0xc0 shr 6) && (i and 0x3) == (i and 0x3000 shr 12)) ||
                    ((i and 0xc) != 0 &&(i and 0xc) == (i and 0x300 shr 6) && (i and 0xc) == (i and 0xc000 shr 12)) ||
                    ((i and 0x30) != 0 &&(i and 0x30) == (i and 0xc00 shr 6) && (i and 0x30) == (i and 0x30000 shr 12)) ||
                    ((i and 0x3) != 0 &&(i and 0x3) == (i and 0x300 shr 8) && (i and 0x3) == (i and 0x30000 shr 16)) ||
                    ((i and 0x30) != 0 &&(i and 0x30) == (i and 0x300 shr 4) && (i and 0x30) == (i and 0x3000 shr 8))
            ) {
                cache.add(i)
                return false
            }

            // check sub status
            val c = if (i < 0) 1 else 2
            for (j in 0 until count) {
                if (i shr 2*j and 0x3 == c) {
                    // remove 'c', turn over first bit, continue next round
                    val m = (i and (0x3 shl 2*j).inv()) xor (1 shl 31)
                    if (valid(m)) {
                        return true
                    }
                }
            }
            cache.add(i)
            return false
        }

        for (j in 0 until count) {
            when (init shr 2*j and 0x3) {
                1 -> {
                    if (valid(init and (0x3 shl 2*j).inv())) {
                        return true
                    }
                }
                2 -> {
                    if (valid((init and (0x3 shl 2*j).inv()) xor (1 shl 31))) {
                        return true
                    }
                }
                else -> {}
            }
        }
        return false
    }
}

fun main() {
    println(Solution794().validTicTacToe(arrayOf("   ", "   ", "   ")))
    println(Solution794().validTicTacToe(arrayOf("O  ", "   ", "   ")))
    println(Solution794().validTicTacToe(arrayOf("XOX", " X ", "   ")))
    println(Solution794().validTicTacToe(arrayOf("XXX", "   ", "OOO")))
    println(Solution794().validTicTacToe(arrayOf("XOX", "O O", "XOX")))
}