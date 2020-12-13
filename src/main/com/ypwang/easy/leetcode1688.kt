package com.ypwang.easy

class Solution1688 {
    fun numberOfMatches(n: Int): Int {
        var c = n
        var match = 0

        while (c > 1) {
            val t = c / 2
            match += t
            c -= t
        }

        return match
    }
}