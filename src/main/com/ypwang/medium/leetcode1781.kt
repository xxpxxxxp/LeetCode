package com.ypwang.medium

class Solution1781 {
    fun beautySum(s: String): Int {
        var rst = 0

        for (i in s.indices) {
            val freq = mutableMapOf<Char, Int>()
            for (j in i until s.length) {
                freq[s[j]] = freq.getOrDefault(s[j], 0) + 1
                rst += freq.values.let { it.max()!! - it.min()!! }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1781().beautySum("aabcb"))
}