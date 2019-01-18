package com.ypwang.medium

class Solution791 {
    fun customSortString(S: String, T: String): String {
        val order = S.withIndex().map { Pair(it.value, it.index) }.toMap()

        return T.toCharArray().sortedWith(Comparator {
            c1, c2 -> order.getOrDefault(c1, Int.MAX_VALUE) - order.getOrDefault(c2, Int.MAX_VALUE)
        }).joinToString("")
    }
}