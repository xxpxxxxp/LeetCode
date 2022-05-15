package com.ypwang.easy

class Solution2273 {
    fun removeAnagrams(words: Array<String>): List<String> {
        val rst = mutableListOf<String>()
        var cur = ""
        for (w in words) {
            val s = w.toCharArray().sorted().joinToString("")
            if (cur != s) {
                rst.add(w)
                cur = s
            }
        }

        return rst
    }
}

fun main() {
    println(Solution2273().removeAnagrams(arrayOf("abba","baba","bbaa","cd","cd")))
}