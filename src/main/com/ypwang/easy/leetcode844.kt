package com.ypwang.easy

class Solution844 {
    fun backspaceCompare(S: String, T: String): Boolean {
        fun helper(s: String): String {
            val r = mutableListOf<Char>()
            for (c in s) {
                when (c) {
                    '#' -> if (!r.isEmpty()) r.removeAt(r.lastIndex)
                    else -> r.add(c)
                }
            }
            return r.joinToString("")
        }
        return helper(S) == helper(T)
    }
}

fun main(args: Array<String>) {
    println(Solution844().backspaceCompare("a#c", "b"))
}