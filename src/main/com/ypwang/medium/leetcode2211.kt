package com.ypwang.medium

class Solution2211 {
    fun countCollisions(directions: String): Int {
        var rst = 0
        var r = 0
        for (c in directions) {
            when (c) {
                'R' -> r++
                'S', 'L' -> {
                    rst += r
                    r = 0
                }
            }
        }
        var l = 0
        for (c in directions.reversed()) {
            when (c) {
                'L' -> l++
                'S', 'R' -> {
                    rst += l
                    l = 0
                }
            }
        }

        return rst
    }
}