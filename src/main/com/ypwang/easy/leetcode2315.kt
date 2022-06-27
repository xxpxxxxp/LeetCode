package com.ypwang.easy

class Solution2315 {
    fun countAsterisks(s: String): Int =
        s.split('|').withIndex().filter { it.index % 2 == 0 }.map { it.value.count { c -> c == '*' } }.sum()
}