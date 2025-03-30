package com.ypwang.easy

class Solution3498 {
    fun reverseDegree(s: String): Int =
        s.withIndex().sumOf { (it.index + 1) * (26 - (it.value - 'a')) }
}
