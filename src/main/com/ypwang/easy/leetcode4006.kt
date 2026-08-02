package com.ypwang.easy

class Solution4006 {
    fun countValidPrefixes(s: String): Int {
        var rst = 0
        var diff = 0

        for (c in s) {
            if (c == '1')
                diff++
            else
                diff--

            if (Math.abs(diff) < 2)
                rst++
        }

        return rst
    }
}
