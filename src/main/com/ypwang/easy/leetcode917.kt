package com.ypwang.easy

class Solution917 {
    fun reverseOnlyLetters(S: String): String {
        val t = S.withIndex()
        val alpha = t.filter { it.value.isLetter() }
        return alpha.map { it.value }.reversed().zip(alpha.map { it.index }).map { IndexedValue(it.second, it.first) }.plus(t.filter { !it.value.isLetter() })
                .sortedBy { it.index }.map { it.value }.joinToString("")
    }
}