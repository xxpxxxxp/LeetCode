package com.ypwang.easy

class Solution3838 {
    fun mapWordWeights(words: Array<String>, weights: IntArray): String =
        words.joinToString("") { ('a' + (25 - it.map { c -> weights[c - 'a'] }.sum() % 26)).toString() }
}
