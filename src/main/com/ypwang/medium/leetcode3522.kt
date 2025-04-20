package com.ypwang.medium

class Solution3522 {
    fun calculateScore(instructions: Array<String>, values: IntArray): Long {
        var score = 0L
        var i = 0

        while (i in instructions.indices && values[i] != Int.MAX_VALUE) {
            when (instructions[i]) {
                "jump" -> {
                    val j = i
                    i += values[i]
                    values[j] = Int.MAX_VALUE
                }
                "add" -> {
                    score += values[i]
                    values[i] = Int.MAX_VALUE
                    i++
                }
            }
        }

        return score
    }
}
