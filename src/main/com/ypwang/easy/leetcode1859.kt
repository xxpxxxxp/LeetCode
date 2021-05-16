package com.ypwang.easy

class Solution1859 {
    fun sortSentence(s: String): String =
        s.split(' ').sortedBy { it.last() }.joinToString(" ") { it.dropLast(1) }
}