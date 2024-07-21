package com.ypwang.medium

class Solution {
    fun doesAliceWin(s: String): Boolean =
        s.any { it in "aeiou".toSet() }
}
