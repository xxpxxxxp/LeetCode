package com.ypwang.easy

class Solution1784 {
    fun checkOnesSegment(s: String): Boolean = s.split('0').filter { it.isNotEmpty() }.size == 1
}