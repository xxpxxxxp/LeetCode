package com.ypwang.easy

class Solution1832 {
    fun checkIfPangram(sentence: String): Boolean {
        val e = BooleanArray(26)
        for (c in sentence)
            e[c - 'a'] = true

        return e.all { it }
    }
}