package com.ypwang.medium

class Solution2109 {
    fun addSpaces(s: String, spaces: IntArray): String {
        val rst = Array(s.length + spaces.size) { ' ' }
        var j = spaces.lastIndex
        var z = rst.lastIndex
        for ((i, v) in s.withIndex().reversed()) {
            rst[z--] = v
            if (j >= 0 && spaces[j] == i) {
                j--
                rst[z--] = ' '
            }
        }

        return rst.joinToString("")
    }
}