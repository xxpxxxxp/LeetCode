package com.ypwang.medium

class Solution848 {
    fun shiftingLetters(S: String, shifts: IntArray): String {
        val c = S.toCharArray()

        var sum = 0
        for (i in shifts.lastIndex downTo 0) {
            sum = (sum + shifts[i]) % 26
            c[i] = 'a' + (c[i] - 'a' + sum) % 26
        }

        return c.joinToString("")
    }
}

fun main() {
    println(Solution848().shiftingLetters("abc", intArrayOf(3,5,9)))
}