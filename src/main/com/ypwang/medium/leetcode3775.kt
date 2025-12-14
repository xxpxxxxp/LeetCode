package com.ypwang.medium

class Solution3775 {
    fun reverseWords(s: String): String {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        val words = s.split(' ')
        val v = words.first().count { it in vowels }
        return words.withIndex().joinToString(" ") {
            if (it.index == 0) it.value
            else if (it.value.count { c -> c in vowels } == v) it.value.reversed()
            else it.value
        }
    }
}
