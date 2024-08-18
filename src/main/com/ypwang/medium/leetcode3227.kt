package com.ypwang.medium

class Solution3227 {
    fun doesAliceWin(s: String): Boolean =
        s.any { it in "aeiou".toSet() }
}
