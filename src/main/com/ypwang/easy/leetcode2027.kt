package com.ypwang.easy

class Solution2027 {
    fun minimumMoves(s: String): Int {
        var i = 0
        var rst = 0
        while (i < s.length) {
            if (s[i] == 'X') {
                i += 3
                rst++
            } else
                i++
        }

        return rst
    }
}