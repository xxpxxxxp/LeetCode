package com.ypwang.medium

class Solution1849 {
    fun splitString(s: String): Boolean {
        fun rec(i: Int, count: Int, pre: Int): Boolean {
            if (i == s.length)
                return count >= 2

            var d = 0
            for (j in i until s.length) {
                d = d * 10 + (s[j] - '0')
                if ((pre == -1 || d == pre-1) && rec(j+1, count+1, d))
                    return true
            }

            return false
        }

        return rec(0, 0, -1)
    }
}