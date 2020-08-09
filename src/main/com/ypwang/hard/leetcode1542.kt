package com.ypwang.hard

class Solution1542 {
    fun longestAwesome(s: String): Int {
        var mask = 0
        var len = 0
        val map = mutableMapOf(0 to -1)

        for ((i, c) in s.withIndex()) {
            mask = mask xor (1 shl (c - '0'))
            if (mask in map) len = maxOf(len, i - map[mask]!!)
            else map[mask] = i

            for (j in 0..9) {
                val b = mask xor (1 shl j)
                if (b in map) len = maxOf(len, i - map[b]!!)
            }
        }

        return len
    }
}