package com.ypwang.medium

class Solution2405 {
    fun partitionString(s: String): Int {
        val set = mutableSetOf<Char>()
        var count = 1

        for (c in s) {
            if (c in set) {
                set.clear()
                count++
            }
            set.add(c)
        }

        return count
    }
}

fun main() {
    println(Solution2405().partitionString("abacaba"))
}