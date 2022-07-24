package com.ypwang.easy

class Solution2351 {
    fun repeatedCharacter(s: String): Char {
        val arr = IntArray(26)
        for (c in s) {
            if (arr[c - 'a'] > 0)
                return c

            arr[c-'a'] = 1
        }

        return ' '
    }
}