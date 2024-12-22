package com.ypwang.easy

class Solution819 {
    fun mostCommonWord(paragraph: String, banned: Array<String>) = paragraph.replace(Regex("[!?',;.]"), "").lowercase().split(' ').groupBy { it }.mapValues { it.value.size }.toMutableMap().apply {
            banned.forEach { b -> this.remove(b) }
        }.maxByOrNull { it.value }!!.key
}

fun main() {
    println(Solution819().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", arrayOf("hit")))
}