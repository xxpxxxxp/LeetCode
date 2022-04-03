package com.ypwang.medium

class Solution2222 {
    fun numberOfWays(s: String): Long {
        // count 0, 1
        var c0 = 0
        var c1 = 0
        // count pair that end with 0, 1
        var m0 = 0L
        var m1 = 0L
        var rst = 0L

        for (c in s) {
            when (c) {
                '0' -> {
                    rst += m1
                    c0++
                    m0 += c1
                }
                '1' -> {
                    rst += m0
                    c1++
                    m1 += c0
                }
            }
        }

        return rst
    }
}