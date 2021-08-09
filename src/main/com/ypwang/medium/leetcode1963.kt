package com.ypwang.medium

class Solution1963 {
    fun minSwaps(s: String): Int {
        var count = 0
        var stack = 0

        for (c in s) {
            if (c == '[')
                stack++
            else if (stack == 0)
                count++
            else
                stack--
        }

        return (count + 1) / 2
    }
}