package com.ypwang.medium

class Solution2716 {
    fun minimizedStringLength(s: String): Int =
        s.groupBy { it }.size
}