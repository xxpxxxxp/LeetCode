package com.ypwang.easy

class Solution1408 {
    fun stringMatching(words: Array<String>): List<String> {
        words.sortBy { it.length }
        val rst = mutableListOf<String>()
        for (i in words.indices) {
            for (j in i+1 until words.size) {
                if (words[j].contains(words[i])) {
                    rst.add(words[i])
                    break
                }
            }
        }

        return rst
    }
}