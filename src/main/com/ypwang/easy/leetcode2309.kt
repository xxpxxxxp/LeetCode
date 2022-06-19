package com.ypwang.easy

class Solution2309 {
    fun greatestLetter(s: String): String {
        val l = BooleanArray(26)
        val u = BooleanArray(26)

        for (c in s) {
            if (c.isLowerCase())
                l[c-'a'] = true
            else
                u[c-'A'] = true
        }

        for (i in 25 downTo 0) {
            if (l[i] && u[i])
                return "${'A' + i}"
        }

        return ""
    }
}