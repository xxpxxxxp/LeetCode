package com.ypwang.hard

class Solution1163 {
    fun lastSubstring(s: String): String {
        var round = s.indices.toMutableSet()
        var inc = 0
        while (round.size != 1) {
            val next = mutableSetOf<Int>()
            var b = 'a'
            for (i in round) {
                if (i + inc >= s.length) continue

                when {
                    s[i+inc] > b -> {
                        next.clear()
                        next.add(i)
                        b = s[i+inc]
                    }
                    s[i+inc] == b -> {
                        next.add(i)
                    }
                    else -> {}
                }
            }

            inc++
            round = next.toSet().filter { it - inc !in next }.toMutableSet()
        }

        return s.substring(round.single())
    }
}

fun main() {
    println(Solution1163().lastSubstring("abab"))
    println(Solution1163().lastSubstring("leetcode"))
    println(Solution1163().lastSubstring((0..200000).map { 'a' }.joinToString("")))
}