package com.ypwang.easy

class Solution1523 {
    fun countOdds(low: Int, high: Int): Int {
        fun range(l: Int, r: Int): Int =
            if (l > r) 0 else 1 + (r - l) / 2

        var l = low
        var r = high

        if (low and 1 == 0)
            l++

        if (high and 1 == 0)
            r--

        return range(l, r)
    }
}