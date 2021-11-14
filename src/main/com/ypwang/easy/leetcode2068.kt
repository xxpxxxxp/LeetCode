package com.ypwang.easy

class Solution {
    fun checkAlmostEquivalent(word1: String, word2: String): Boolean {
        val ar1 = IntArray(26)
        val ar2 = IntArray(26)

        for (i in word1.indices) {
            ar1[word1[i] - 'a']++
            ar2[word2[i] - 'a']++
        }

        return ar1.zip(ar2).all { Math.abs(it.first - it.second) < 4 }
    }
}