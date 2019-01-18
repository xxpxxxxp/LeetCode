package com.ypwang.medium

import java.util.*

class Solution820 {
    fun minimumLengthEncoding(words: Array<String>): Int {
        var len = 0

        if (words.isEmpty()) {
            return len
        }

        val tmp = LinkedList<String>()
        tmp.addAll(words)
        while (tmp.isNotEmpty()) {
            val base = tmp.pop()
            len += (base.length + 1)
            while (tmp.isNotEmpty() && base.endsWith(tmp.peek())) {
                tmp.pop()
            }
        }

        return len
    }
}

fun main(args: Array<String>) {
    println(Solution820().minimumLengthEncoding(arrayOf("time", "me", "bell")))
}