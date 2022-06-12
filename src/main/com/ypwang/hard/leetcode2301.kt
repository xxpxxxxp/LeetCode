package com.ypwang.hard

class Solution2301 {
    fun matchReplacement(s: String, sub: String, mappings: Array<CharArray>): Boolean {
        val map = mappings.map { it[0] to it[1] }.groupBy { it.first }.mapValues { it.value.map { kv -> kv.second }.toSet() }
        lable@for (i in 0 .. s.length - sub.length) {
            for (j in sub.indices) {
                if (s[i+j] != sub[j] && (sub[j] !in map || s[i+j] !in map[sub[j]]!!))
                    continue@lable
            }
            return true
        }
        return false
    }
}

fun main() {
    println(Solution2301().matchReplacement("fooleetbar", "f00l", arrayOf(charArrayOf('o','0'))))
    println(Solution2301().matchReplacement("fool3e7bar", "leet", arrayOf(charArrayOf('e','3'), charArrayOf('t','7'), charArrayOf('t', '8'))))
}