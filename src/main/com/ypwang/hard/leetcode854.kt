package com.ypwang.hard

import java.lang.Exception

class Solution854 {
    fun kSimilarity(A: String, B: String): Int {
        fun neighbors(s: String): List<String> {
            val rst = mutableListOf<String>()
            var i = 0
            while (s[i] == B[i]) i++

            for (j in i+1 until s.length) {
                if (s[j] == B[i]) {
                    rst.add(s.substring(0, i) + B[i] + s.substring(i+1, j) + s[i] + s.substring(j+1))
                }
            }

            return rst
        }

        var queue = listOf(A)
        val visited = mutableSetOf<String>()
        var count = 0
        while (queue.isNotEmpty()) {
            val next = mutableListOf<String>()
            visited.addAll(queue)
            for (s in queue) {
                if (s == B) return count
                for (t in neighbors(s)) {
                    if (t !in visited) {
                        next.add(t)
                    }
                }
            }
            queue = next
            count++
        }

        throw Exception("")
    }
}

fun main() {
    println(Solution854().kSimilarity("aabc", "abca"))
}