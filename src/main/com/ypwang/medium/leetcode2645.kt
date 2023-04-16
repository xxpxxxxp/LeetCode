package com.ypwang.medium

class Solution2645 {
    fun addMinimum(word: String): Int {
        var c = 1
        var i = 0
        var j = 0
        while (i < word.length) {
            if (j == 3) {
                c++
                j = 0
            }

            if (word[i] == 'a' + j) {
                i++
            }

            j++
        }

        return 3 * c - word.length
    }
}