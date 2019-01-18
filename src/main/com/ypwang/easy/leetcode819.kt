package com.ypwang.easy

class Solution819 {
    fun mostCommonWord(paragraph: String, banned: Array<String>) = paragraph.replace(Regex("[!?',;.]"), "").toLowerCase().split(' ').groupBy { it }.mapValues { it.value.size }.toMutableMap().apply {
            banned.forEach { b -> this.remove(b) }
        }.maxBy { it.value }!!.key
}

fun main(args: Array<String>) {
    println(Solution819().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", arrayOf("hit")))
}