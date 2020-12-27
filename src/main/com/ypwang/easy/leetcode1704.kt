package com.ypwang.easy

class Solution1704 {
    fun halvesAreAlike(s: String): Boolean {
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

        var count = 0
        for (i in 0 until s.length / 2) {
            if (s[i] in vowels)
                count++
        }

        for (i in s.length / 2 until s.length) {
            if (s[i] in vowels)
                count--
        }

        return count == 0
    }
}