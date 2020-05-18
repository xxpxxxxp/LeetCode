package com.ypwang.medium

class Solution1451 {
    fun arrangeWords(text: String): String = text.split(' ').sortedBy { it.length }.map { it.decapitalize() }.joinToString(" ").capitalize()
}