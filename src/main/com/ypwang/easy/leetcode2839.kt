package com.ypwang.easy

class Solution2839 {
    fun canBeEqual(s1: String, s2: String): Boolean =
        minOf(s1[0], s1[2]) == minOf(s2[0], s2[2]) &&
                maxOf(s1[0], s1[2]) == maxOf(s2[0], s2[2]) &&
                minOf(s1[1], s1[3]) == minOf(s2[1], s2[3]) &&
                maxOf(s1[1], s1[3]) == maxOf(s2[1], s2[3])
}