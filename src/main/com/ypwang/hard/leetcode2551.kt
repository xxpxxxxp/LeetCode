package com.ypwang.hard

class Solution2551 {
    fun putMarbles(weights: IntArray, k: Int): Long {
        val diff = (1 until weights.size).map { weights[it-1] + weights[it] }.sorted()
        return diff.takeLast(k-1).fold(1L){ a, b -> a + b } - diff.take(k-1).fold(1L){ a, b -> a + b }
    }
}