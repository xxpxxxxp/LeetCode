package com.ypwang.easy

class Solution1961 {
    fun isPrefixString(s: String, words: Array<String>): Boolean {
        var i = 0

        for (word in words) {
            if (i == s.length)
                return true

            if (i + word.length > s.length)
                return false

            for (j in word.indices) {
                if (s[i + j] != word[j])
                    return false
            }

            i += word.length
        }

        return i == s.length
    }
}