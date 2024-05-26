package com.ypwang.easy

class Solution3110 {
    fun scoreOfString(s: String): Int = (0 until s.lastIndex).map { Math.abs(s[it+1]-s[it]) }.sum()
}