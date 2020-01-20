package com.ypwang.hard

class Solution1316 {
    fun distinctEchoSubstrings(text: String): Int {
        val rst = mutableSetOf<String>()
        for (i in 1 until text.length) {
            val candidates = (maxOf(2 * i - text.length, 0) until i).toList().toTypedArray()
            var end = candidates.size
            var c = 0
            while (end > 0) {
                var x = 0
                var y = 0
                while (y < end) {
                    if (text[candidates[y]] == text[i + c]) {
                        candidates[x] = candidates[y] + 1
                        if (candidates[x] == i) rst.add(text.substring(i, i + c + 1))
                        else x++
                    }
                    y++
                }
                end = x
                c++
            }
        }

        return rst.size
    }
}

fun main() {
    println(Solution1316().distinctEchoSubstrings("abcabcabc"))
    println(Solution1316().distinctEchoSubstrings("leetcodeleetcode"))
}