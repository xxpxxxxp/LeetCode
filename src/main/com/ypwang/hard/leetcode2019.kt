package com.ypwang.hard

import java.util.*

class Solution2019 {
    private fun solve(s: String): Int {
        val stack = Stack<Int>()
        var idx = 0
        while (idx < s.length) {
            when (s[idx]) {
                in '0'..'9' -> stack.add(s[idx] - '0')
                '*' -> {
                    stack.add((s[++idx] - '0') * stack.pop())
                }
            }
            idx++
        }

        return stack.sum()
    }

    fun scoreOfStudents(s: String, answers: IntArray): Int {
        val correct = solve(s)

        val numbers = (s.length + 1) / 2
        val dp = Array(numbers) { Array(numbers) { mutableSetOf<Int>() } }

        for (i in 0 until numbers)
            dp[i][i].add(s[2 * i] - '0')

        for (len in 1 until numbers) {
            for (i in 0 until numbers - len) {
                for (j in i until i+len) {
                    val left = dp[i][j]
                    val right = dp[j+1][i+len]
                    val op = s[2 * j + 1]
                    val rst = left.flatMap { l ->
                        right.map { r ->
                            when (op) {
                                '+' -> l + r
                                '*' -> l * r
                                else -> throw Exception("invalid input!")
                            }
                        }.filter { it <= 1000 }
                    }.toSet()

                    dp[i][i+len].addAll(rst)
                }
            }
        }

        val all = dp[0][numbers-1]
        return answers.map {
            when (it) {
                correct -> 5
                in all -> 2
                else -> 0
            }
        }.sum()
    }
}

fun main() {
    println(Solution2019().scoreOfStudents("8+6+8+4*4+4*6+4*6+2*2+8*8+4*4+6", intArrayOf(638,176,176,206,992,176,682,229,990,33,176)))
    println(Solution2019().scoreOfStudents("7+3*1*2", intArrayOf(20,13,42)))
    println(Solution2019().scoreOfStudents("3+5*2", intArrayOf(13,0,10,13,13,16,16)))
    println(Solution2019().scoreOfStudents("6+0*1", intArrayOf(12,9,6,4,8,6)))
}