package com.ypwang.easy

class Solution2490 {
    fun isCircularSentence(sentence: String): Boolean {
        val words = sentence.split(' ')
        return words.indices.all {
            val pre = if (it > 0) it - 1 else words.lastIndex
            words[pre].last() == words[it].first()
        }
    }
}