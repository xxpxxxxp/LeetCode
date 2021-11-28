package com.ypwang.easy

class Solution2085 {
    fun countWords(words1: Array<String>, words2: Array<String>): Int =
        words1.groupBy { it }.filter { it.value.size == 1 }.map { it.key }.intersect(
            words2.groupBy { it }.filter { it.value.size == 1 }.map { it.key }.toSet()
        ).size
}