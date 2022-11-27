package com.ypwang.medium

class Solution2486 {
    fun appendCharacters(s: String, t: String): Int {
        var i = 0
        var j = 0

        while (i < s.length) {
            if (j == t.length)
                break
            if (s[i] == t[j])
                j++
            i++
        }

        return t.length - j
    }
}