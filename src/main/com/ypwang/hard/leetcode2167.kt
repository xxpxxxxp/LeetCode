package com.ypwang.hard

class Solution2167 {
    fun minimumTime(s: String): Int =
        s.withIndex().fold(0 to s.length) { (left, res), (i, c) ->
            val l = minOf(left + (c - '0') * 2, i + 1)
            l to minOf(res, l + s.lastIndex - i)
        }.second
}