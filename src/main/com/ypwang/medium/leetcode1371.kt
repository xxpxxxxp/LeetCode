package com.ypwang.medium

class Solution1371 {
    fun findTheLongestSubstring(s: String): Int {
        val map = mutableMapOf(0 to -1)
        var rst = 0
        var start = 0
        val pos = "aeiou".withIndex().map { it.value to it.index }.toMap()
        for ((i, c) in s.withIndex()) {
            if (c in pos)
                start = start xor (1 shl pos[c]!!)

            if (start in map) rst = maxOf(rst, i - map[start]!!)
            else map[start] = i
        }

        return rst
    }
}