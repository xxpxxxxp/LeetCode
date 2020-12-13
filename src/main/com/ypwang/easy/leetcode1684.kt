package com.ypwang.easy

class Solution1684 {
    private fun code(str: String): Int {
        var i = 0
        for (c in str) {
            i = i or (1 shl (c - 'a'))
        }

        return i
    }

    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        val mask = code(allowed)
        return words.count { code(it).let { m -> m and mask == m } }
    }
}