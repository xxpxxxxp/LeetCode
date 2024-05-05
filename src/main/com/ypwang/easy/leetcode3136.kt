package com.ypwang.easy

class Solution3136 {
    fun isValid(word: String): Boolean {
        var vow = false
        var con = false

        if (word.length < 3)
            return false

        for (c in word) {
            if (!c.isLetterOrDigit())
                return false
            if (c.isLetter()) {
                if (c.lowercaseChar() in setOf('a', 'e', 'i', 'o', 'u'))
                    vow = true
                else
                    con = true
            }
        }

        return vow && con
    }
}
