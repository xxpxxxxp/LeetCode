package com.ypwang.easy

class Solution1805 {
    fun numDifferentIntegers(word: String): Int =
        word.split(Regex("""[A-Za-z]""")).filter { it.isNotEmpty() }.map { it.trimStart('0') }.toSet().size
}
