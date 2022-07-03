package com.ypwang.easy

class Solution2325 {
    fun decodeMessage(key: String, message: String): String {
        val table = CharArray(26) { '0' }
        var index = 0
        for (c in key) {
            if (c.isLetter() && c != ' ' && table[c - 'a'] == '0') {
                table[c - 'a'] = 'a' + (index++)
            }
        }
        return message.map { if (it == ' ') ' ' else table[it - 'a'] }.joinToString("")
    }
}

fun main() {
    println(Solution2325().decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"))
}