package com.ypwang.easy

class Solution1332 {
    fun removePalindromeSub(s: String): Int {
        if (s.isEmpty()) return 0
        var i = 0
        var j = s.lastIndex
        while (i < j) {
            if (s[i] != s[j])
                return 2
            i++
            j--
        }
        return 1
    }
}