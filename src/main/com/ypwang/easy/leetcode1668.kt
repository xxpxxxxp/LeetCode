package com.ypwang.easy

class Solution1668 {
    fun maxRepeating(sequence: String, word: String): Int {
        val count = IntArray(sequence.length+1)
        var rst = 0

        for (i in sequence.indices) {
            val c = count[i]
            if (i + word.length <= sequence.length && sequence.substring(i, i + word.length) == word) {
                rst = maxOf(rst, c+1)
                count[i + word.length] = c+1
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1668().maxRepeating("ababc", "ab"))
    println(Solution1668().maxRepeating("ababc", "ba"))
    println(Solution1668().maxRepeating("ababc", "ac"))
}