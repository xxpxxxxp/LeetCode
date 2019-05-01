package com.ypwang.medium

class Solution678 {
    fun checkValidString(s: String): Boolean {
        var initial = setOf(0)

        for (c in s) {
            when (c) {
                '(' -> initial = initial.map { it + 1 }.toSet()
                ')' -> initial = initial.map { it - 1 }.filter { it >= 0 }.toSet()
                '*' -> {
                    val new = mutableSetOf<Int>()
                    new.addAll(initial)
                    new.addAll(initial.map { it + 1 })
                    new.addAll(initial.map { it - 1 }.filter { it >= 0 })
                    initial = new
                }
            }

            if (initial.isEmpty()) return false
        }

        return 0 in initial
    }
}

fun main() {
    println(Solution678().checkValidString("(*))"))
}