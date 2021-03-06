package com.ypwang.easy

class Solution1614 {
    fun maxDepth(s: String): Int {
        var max = 0
        var count = 0
        for (c in s) {
            when (c) {
                '(' -> {
                    count++
                    max = maxOf(max, count)
                }
                ')' ->
                    count--
            }
        }

        return max
    }
}