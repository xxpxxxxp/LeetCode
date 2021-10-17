package com.ypwang.medium

class Solution2038 {
    fun winnerOfGame(colors: String): Boolean {
        var a = 0
        var b = 0
        for (i in 0 .. colors.length - 3) {
            when (colors.substring(i, i+3)) {
                "AAA" -> a++
                "BBB" -> b++
            }
        }

        return a > b
    }
}

fun main() {
    println(Solution2038().winnerOfGame("AAAABBBB"))
}