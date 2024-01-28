package com.ypwang.easy

class Solution3019 {
    fun countKeyChanges(s: String): Int =
        (1 until s.length).count { s[it].lowercaseChar() != s[it-1].lowercaseChar() }
}