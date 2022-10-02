package com.ypwang.easy

class Solution2423 {
    fun equalFrequency(word: String): Boolean {
        val freq = word.groupBy { it }.map { it.value.size }.groupBy { it }.mapValues { it.value.size }

        return when (freq.size) {
            1 -> freq.toList().first().first == 1 || freq.toList().first().second == 1
            2 -> {
                val (l, h) = freq.toList().sortedBy { it.first }
                (l.first == 1 && l.second == 1) || (h.second == 1 && h.first == l.first + 1)
            }
            else -> false
        }
    }
}

fun main() {
    println(Solution2423().equalFrequency("abbcc"))
}