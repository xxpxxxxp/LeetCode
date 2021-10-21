package com.ypwang.medium

class Solution1218 {
    fun longestSubsequence(arr: IntArray, difference: Int): Int {
        val cur = mutableMapOf<Int, Int>()

        for (e in arr) {
            val c = cur.getOrDefault(e - difference, 0) + 1
            if (e !in cur || cur[e]!! < c) cur[e] = c
        }

        return cur.values.maxOrNull()!!
    }
}