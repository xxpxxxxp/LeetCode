package com.ypwang.medium

class Solution3968 {
    fun maxDistance(moves: String): Int {
        var x = 0
        var y = 0
        var count = 0
        for (c in moves.toCharArray()) {
            when (c) {
                'L' -> y--
                'R' -> y++
                'U' -> x++
                'D' -> x--
                '_' -> count++
            }
        }

        return Math.abs(x) + Math.abs(y) + count
    }
}
