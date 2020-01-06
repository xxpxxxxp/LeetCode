package com.ypwang.medium

class Solution1297 {
    fun maxFreq(s: String, maxLetters: Int, minSize: Int, maxSize: Int): Int {
        var start = 0
        val window = mutableMapOf<Char, Int>()
        val occurrence = mutableMapOf<String, Int>()
        for ((i, c) in s.withIndex())
        {
            window[c] = window.getOrDefault(c, 0) + 1
            if (i - start + 1 > minSize)
            {
                window[s[start]] = window[s[start]]!! - 1
                if (window[s[start]]!! == 0) window.remove(s[start])
                start++
            }
            if(i - start + 1 == minSize && window.size <= maxLetters)
                s.substring(start, start + minSize).let { occurrence[it] = occurrence.getOrDefault(it, 0) + 1 }
        }
        return occurrence.values.max() ?: 0
    }
}

fun main() {
    println(Solution1297().maxFreq("aababcaab",
            2,
            3,
            4))
}