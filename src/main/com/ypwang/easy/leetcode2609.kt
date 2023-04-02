package com.ypwang.easy

class Solution2609 {
    fun findTheLongestBalancedSubstring(s: String): Int {
        var c0 = 0
        var c1 = 0
        var rst = 0

        for (c in s) {
            if (c == '0') {
                if (c1 > 0) {
                    rst = maxOf(rst, 2 * minOf(c0, c1))
                    c0 = 0
                    c1 = 0
                }
                c0++
            } else if (c == '1') {
                c1++
            }
        }

        return maxOf(rst, 2 * minOf(c0, c1))
    }
}
