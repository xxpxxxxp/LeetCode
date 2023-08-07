package com.ypwang.easy

class Solution2810 {
    fun finalString(s: String): String {
        val ls = mutableListOf<Char>()
        var flip = false

        for (c in s) {
            if (c == 'i') {
                flip = !flip
                continue
            }
            if (flip)
                ls.add(0, c)
            else
                ls.add(c)
        }

        return if (flip) ls.joinToString("").reversed() else ls.joinToString("")
    }
}