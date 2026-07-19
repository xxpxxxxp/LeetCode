package com.ypwang.easy

class Solution3992 {
    fun rearrangeString(s: String, x: Char, y: Char): String {
        var i = 0
        var j = s.lastIndex
        val cs = s.toCharArray()

        while (true) {
            while (i < j && cs[i] != x)
                i++

            while (i < j && cs[j] != y)
                j--

            if (i == j)
                break

            cs[i] = y
            cs[j] = x
        }

        return String(cs)
    }
}
