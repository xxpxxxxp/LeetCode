package com.ypwang.easy

class Solution1446 {
    fun maxPower(s: String): Int {
        var i = 0
        var j = 0
        var rst = 0

        while (j < s.length) {
            if (s[i] == s[j]) j++
            else {
                rst = maxOf(rst, j - i)
                i = j
            }
        }

        return maxOf(rst, j - i)
    }
}