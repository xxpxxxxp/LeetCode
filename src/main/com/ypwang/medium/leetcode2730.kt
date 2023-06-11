package com.ypwang.medium

class Solution2730 {
    fun longestSemiRepetitiveSubstring(s: String): Int {
        val repeated = mutableListOf<Int>()
        for (i in 1 until s.length) {
            if (s[i-1] == s[i])
                repeated.add(i)
        }
        if (repeated.size < 2)
            return s.length

        var start = 0
        var rst = 0
        for ((i, idx) in repeated.withIndex()) {
            var end = s.length
            if (i < repeated.lastIndex)
                end = repeated[i+1]
            rst = maxOf(rst, end - start)
            start = idx
        }
        return rst
    }
}

fun main() {
    println(Solution2730().longestSemiRepetitiveSubstring("1101234883"))
}