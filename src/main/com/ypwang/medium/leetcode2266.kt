package com.ypwang.medium

class Solution2266 {
    private val mapping = mapOf(
        '2' to 3,
        '3' to 3,
        '4' to 3,
        '5' to 3,
        '6' to 3,
        '7' to 4,
        '8' to 3,
        '9' to 4
    )

    fun countTexts(pressedKeys: String): Int {
        val ls = mutableListOf<Pair<Char, Int>>()
        var char = pressedKeys.first()
        var count = 0
        for (c in pressedKeys) {
            if (c != char) {
                ls.add(char to count)
                count = 0
                char = c
            }
            count++
        }
        ls.add(char to count)

        val max = ls.map { it.second }.maxOrNull()!!
        val dp = Array(2) { IntArray(max+1) }
        for (i in 0 until 2) {
            dp[i][0] = 1
            dp[i][1] = 1
            val j = i + 3
            for (z in 2..max)
                dp[i][z] = (1..j).map {
                    if (z < it) 0
                    else dp[i][z-it]
                }.fold(0L) { c, x -> (c + x) % 1000000007 }.toInt()
        }

        return ls.map { (c, v) -> dp[mapping[c]!! - 3][v] }.fold(1L) { c, i -> c * i % 1000000007 }.toInt()
    }
}

fun main() {
    println(Solution2266().countTexts("22233"))
    println(Solution2266().countTexts("222222222222222222222222222222222222"))
}