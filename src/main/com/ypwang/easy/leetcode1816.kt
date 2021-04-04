package com.ypwang.easy

class Solution1816 {
    fun truncateSentence(s: String, k: Int): String = s.split(' ').take(k).joinToString(" ")
}