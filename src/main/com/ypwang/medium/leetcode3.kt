package com.ypwang.medium

import kotlin.math.max

class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableMapOf<Char, Int>()

        var j = 0
        var count = 0
        for ((i, c) in s.withIndex()) {
            if (c in set) {
                j = max(j, set[c]!! + 1)
            }
            set[c] = i

            count = max(count, i - j + 1)
        }

        return count
    }
}

fun main(args: Array<String>) {
    println(Solution3().lengthOfLongestSubstring("abba"))
    println(Solution3().lengthOfLongestSubstring("bbbbb"))
    println(Solution3().lengthOfLongestSubstring("pwwkew"))
}