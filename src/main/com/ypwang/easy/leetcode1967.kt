package com.ypwang.easy

class Solution1967 {
    fun numOfStrings(patterns: Array<String>, word: String): Int =
        patterns.count { word.contains(it) }
}