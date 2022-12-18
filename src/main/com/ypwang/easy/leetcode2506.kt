package com.ypwang.easy

class Solution2506 {
    fun similarPairs(words: Array<String>): Int =
        words.map { it.fold(0){ i, c -> i or (1 shl (c - 'a')) } }
            .groupBy { it }
            .map { it.value.size }
            .map { it * (it-1) / 2 }
            .sum()
}