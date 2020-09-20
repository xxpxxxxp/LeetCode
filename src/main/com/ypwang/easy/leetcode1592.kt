package com.ypwang.easy

class Solution1592 {
    fun reorderSpaces(text: String): String {
        val words = text.split(' ').filter { it.isNotEmpty() }
        val len = words.sumBy { it.length }
        val space = text.length - len
        if (words.size == 1)
            return words.first() + (0 until space).map { ' ' }.joinToString("")

        val d = space / (words.size - 1)
        val splitter = (0 until d).map { ' ' }.joinToString("")

        return words.joinToString(splitter) + (0 until (space - d * (words.size - 1))).map { ' ' }.joinToString("")
    }
}