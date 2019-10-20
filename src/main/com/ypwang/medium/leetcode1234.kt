package com.ypwang.medium

class Solution1234 {
    fun balancedString(s: String): Int {
        // sliding window
        val c = s.length / 4
        val redundant = s.groupBy { it }.mapValues { it.value.size - c }.filter { it.value > 0 }
        if (redundant.isEmpty()) return 0

        var min = Int.MAX_VALUE
        var i = 0
        var j = 0
        val window = mutableMapOf('Q' to 0, 'W' to 0, 'E' to 0, 'R' to 0)

        while (j < s.length) {
            while (j < s.length && redundant.any { it.value > window[it.key]!! }) {
                window[s[j]] = 1 + window.getOrDefault(s[j], 0)
                j++
            }

            if (j < s.length || redundant.all { it.value <= window[it.key]!! }) {
                while (s[i] !in redundant || redundant[s[i]]!! <= window[s[i]]!! - 1) {
                    window[s[i]] = window[s[i]]!! - 1
                    i++
                }
                min = minOf(min, j-i)
            }

            window[s[i]] = window[s[i]]!! - 1
            i++
        }

        return min
    }
}

fun main() {
    println(Solution1234().balancedString("WQWRQQQW"))
    println(Solution1234().balancedString("QWER"))
    println(Solution1234().balancedString("QQWE"))
    println(Solution1234().balancedString("QQQW"))
    println(Solution1234().balancedString("QQQQ"))
}