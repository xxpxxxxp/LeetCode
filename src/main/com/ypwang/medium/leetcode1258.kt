package com.ypwang.medium

class Solution1258 {
    fun generateSentences(synonyms: List<List<String>>, text: String): List<String> {
        val syntex = synonyms.map { it.sorted() }.flatMap { it.map { w -> w to it } }.toMap()
        var queue = listOf("")

        for (w in text.split(" ")) {
            queue = if (w in syntex) {
                val next = mutableListOf<String>()
                for (pre in queue) {
                    next.addAll(syntex[w]!!.map { "$pre $it" })
                }
                next
            } else queue.map { "$it $w" }
        }

        return queue
    }
}

fun main() {
    println(Solution1258().generateSentences(listOf(
            listOf("happy","joy"), listOf("sad","sorrow"), listOf("joy","cheerful")
    ), "I am happy today but was sad yesterday"))
}