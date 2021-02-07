package com.ypwang.medium

class Solution1750 {
    fun minimumLength(s: String): Int {
        val ls = mutableListOf<Pair<Char, Int>>()
        var start = s[0]
        var count = 1

        for (i in 1 until s.length) {
            if (start != s[i]) {
                ls.add(start to count)
                start = s[i]
                count = 0
            }
            count++
        }
        ls.add(start to count)

        while (ls.size > 1 && ls.first().first == ls.last().first) {
            ls.removeAt(0)
            ls.removeAt(ls.lastIndex)
        }

        return if (ls.size == 1 && ls.single().second > 1) 0 else ls.sumBy { it.second }
    }
}