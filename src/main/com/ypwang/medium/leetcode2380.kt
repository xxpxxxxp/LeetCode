package com.ypwang.medium

class Solution2380 {
    fun secondsToRemoveOccurrences(s: String): Int {
        var rst = 0
        var prefix = 0
        var prev = 0
        for ((i, c) in s.withIndex()) {
            if (c == '1') {
                rst = maxOf(prev, i - prefix)
                prefix++
                if (rst > 0)
                    prev = rst + 1
            }
        }

        return rst
    }
}