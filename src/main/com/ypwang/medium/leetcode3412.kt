package com.ypwang.medium

class Solution3412 {
    fun calculateScore(s: String): Long {
        val pre = Array(26) { mutableListOf<Int>() }
        var rst = 0L
        for ((i, c) in s.withIndex()) {
            val t = c - 'a'
            if (pre[25-t].isNotEmpty())
                rst += i - pre[25-t].removeLast()
            else
                pre[t].add(i)
        }

        return rst
    }
}
