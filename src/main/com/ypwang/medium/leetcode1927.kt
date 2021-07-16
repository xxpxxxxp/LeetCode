package com.ypwang.medium

class Solution1927 {
    fun sumGame(num: String): Boolean =
        num.withIndex().map {
            val op = if (it.index < num.length / 2) 1.0 else -1.0
            if (it.value == '?')
                op * 4.5
            else
                op * (it.value - '0')
        }.sum() != 0.0
}