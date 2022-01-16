package com.ypwang.medium

class Solution2139 {
    fun minMoves(target: Int, maxDoubles: Int): Int {
        var t = target
        var c = maxDoubles
        var s = 0

        while (t != 1 && c > 0) {
            if (t % 2 == 1)
                t--
            else {
                t /= 2
                c--
            }
            s++
        }

        return s + t - 1
    }
}