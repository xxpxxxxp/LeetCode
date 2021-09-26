package com.ypwang.medium

class Solution2018 {
    fun placeWordInCrossword(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board[0].size

        return (
                (0 until m).asSequence().map { board[it].joinToString("") } +
                (0 until n).asSequence().map { c -> (0 until m).map { board[it][c] }.joinToString("") }
        ).any { it.split('#').filter { sb -> sb.length == word.length }.flatMap { sb -> listOf(sb, sb.reversed()) }.any { sb -> sb.zip(word).all { p -> p.first == ' ' || p.first == p.second } } }
    }
}