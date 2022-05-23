package com.ypwang.easy

class Solution2278 {
    fun percentageLetter(s: String, letter: Char): Int = 100 * s.count { it == letter } / s.length
}