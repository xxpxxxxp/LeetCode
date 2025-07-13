package com.ypwang.hard

class Solution3614 {
    fun processStr(s: String, k: Long): Char {
        var k = k
        var len = 0L
        for (c in s) {
            if (c.isLowerCase())
                len++
            else if (c == '*' && len > 0)
                len--
            else if (c == '#')
                len *= 2
        }
        if (k >= len)
            return '.'

        for (i in s.length - 1 downTo 0) {
            val c = s[i]
            if (c.isLowerCase()) {
                if (k == len - 1)
                    return c
                len--
            } else if (c == '*')
                len++
            else if (c == '#') {
                len /= 2
                if (k >= len)
                    k -= len
            } else if (c == '%')
                k = len - 1 - k
        }
        return '.'
    }
}
