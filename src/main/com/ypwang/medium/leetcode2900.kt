package com.ypwang.medium

class Solution2900 {
    fun getWordsInLongestSubsequence(n: Int, words: Array<String>, groups: IntArray): List<String> {
        var prev = 1 - groups[0]
        val rst = mutableListOf<String>()
        for (i in 0 until n) {
            if (groups[i] != prev) {
                prev = 1 - prev
                rst.add(words[i])
            }
        }
        return rst
    }
}