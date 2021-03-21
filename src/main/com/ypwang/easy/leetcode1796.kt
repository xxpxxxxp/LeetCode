package com.ypwang.easy

class Solution1796 {
    fun secondHighest(s: String): Int {
        val set = BooleanArray(10)
        for (c in s) {
            if (c.isDigit())
                set[c-'0'] = true
        }

        return set.withIndex().filter { it.value }.dropLast(1).lastOrNull()?.index ?: -1
    }
}