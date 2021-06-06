package com.ypwang.medium

class Solution1888 {
    fun minFlips(s: String): Int {
        var res = Int.MAX_VALUE
        var s0 = 0
        var s1 = 0

        for (i in 0 until 2 * s.length) {
            if (s[i % s.length] - '0' != i % 2)
                s0++

            if (s[i % s.length] - '0' != (i+1) % 2)
                s1++

            if (i >= s.lastIndex) {
                if (i >= s.length) {
                    if (s[i - s.length] - '0' != (i - s.length) % 2)
                        s0--

                    if (s[i - s.length] - '0' != (i + 1 - s.length) % 2)
                        s1--
                }

                res = minOf(res, s0, s1)
            }
        }
        return res
    }
}