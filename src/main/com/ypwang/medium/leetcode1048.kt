package com.ypwang.medium

class Solution1048 {
    fun longestStrChain(words: Array<String>): Int {
        val t = words.groupBy { it.length }.toList().sortedBy { it.first }.map { it.second.map { w -> w to 1 }.toMap().toMutableMap() }.toTypedArray()

        var max = 1
        for (i in 1 until t.size) {
            val ws = t[i]
            val previous = t[i-1]

            for ((w, c) in ws) {
                for (j in 0 until w.length) {
                    val sub = w.substring(0, j) + w.substring(j+1, w.length)
                    if (previous.getOrDefault(sub, 0) + 1 > c) {
                        ws[w] = previous.getOrDefault(sub, 0) + 1
                        if (ws[w]!! > max) max = ws[w]!!
                    }
                }
            }
        }
        return max
    }
}

fun main() {
    println(Solution1048().longestStrChain(arrayOf("a","b","ba","bca","bda","bdca")))
}