package com.ypwang.medium

import java.lang.StringBuilder

class Solution649 {
    private fun remove(s: String, c: Char, count: Int): String {
        var countk = count
        val sb = StringBuilder()
        for (cs in s) {
            if (countk > 0 && cs == c) {
                countk--
                continue
            }

            sb.append(cs)
        }
        return sb.toString()
    }

    fun predictPartyVictory(senate: String): String {
        if (senate.all { it == 'R' }) return "Radiant"
        if (senate.all { it == 'D' }) return "Dire"

        val nextRound = StringBuilder()
        var R = 0
        for (s in senate) {
            when (s) {
                'R' -> {
                    R++
                    if (R > 0)
                        nextRound.append('R')
                }
                'D' -> {
                    R--
                    if (R < 0)
                        nextRound.append('D')
                }
                else -> {}
            }
        }

        val n = if (R != 0) remove(nextRound.toString(), if (R > 0) 'D' else 'R', Math.abs(R)) else nextRound.toString()
        return predictPartyVictory(n)
    }
}

fun main() {
    println(Solution649().predictPartyVictory("DDRRR"))
}