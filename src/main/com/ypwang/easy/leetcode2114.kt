package com.ypwang.easy

class Solution2114 {
    fun mostWordsFound(sentences: Array<String>): Int =
        sentences.map { it.split(' ').size }.maxOrNull()!!
}