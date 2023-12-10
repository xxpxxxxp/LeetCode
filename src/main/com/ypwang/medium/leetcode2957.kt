package com.ypwang.medium

class Solution2957 {
    fun removeAlmostEqualCharacters(word: String): Int {
        var i = 1
        var c = 0
        while (i < word.length) {
            if (Math.abs(word[i-1] - word[i]) < 2) {
                c++
                i++
            }
            i++
        }

        return c
    }
}