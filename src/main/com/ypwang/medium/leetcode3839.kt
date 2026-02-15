package com.ypwang.medium

class Solution3839 {
    fun prefixConnected(words: Array<String>, k: Int): Int =
        words.filter { it.length >= k }
            .map { it.take(k) }
            .groupBy { it }
            .filter { it.value.size > 1 }
            .size
}
