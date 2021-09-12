package com.ypwang.easy

class Solution2000 {
    fun reversePrefix(word: String, ch: Char): String {
        val idx = word.indexOf(ch)

        if (idx == -1)
            return word

        return word.substring(0, idx+1).reversed() + word.substring(idx+1)
    }
}