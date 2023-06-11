package com.ypwang.medium

class Solution2734 {
    fun smallestString(s: String): String {
        val start = s.indexOfFirst { it != 'a' }
        if (start == -1)
            return s.substring(0, s.lastIndex) + "z"

        var end = s.indexOf('a', start+1)
        if (end == -1)
            end = s.length

        val cs = s.toCharArray()
        for (i in start until end)
            cs[i] = cs[i] - 1

        return String(cs)
    }
}