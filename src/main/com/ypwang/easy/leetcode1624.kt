package com.ypwang.easy

class Solution1624 {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
        val idx = IntArray(26){-1}
        var rst = -1

        for ((i, c) in s.withIndex()) {
            val t = c - 'a'
            if (idx[t] == -1)
                idx[t] = i
            else
                rst = maxOf(rst, i - idx[t] - 1)
        }

        return rst
    }
}