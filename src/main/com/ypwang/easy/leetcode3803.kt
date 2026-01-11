package com.ypwang.easy

class Solution3803 {
    fun residuePrefixes(s: String): Int {
        val distinct = mutableSetOf<Char>()
        var rst = 0
        for ((i, c) in s.withIndex()) {
            distinct.add(c)
            if ((i+1) % 3 == distinct.size)
                rst++
        }

        return rst
    }
}
