package com.ypwang.medium

class Solution1324 {
    fun printVertically(s: String): List<String> {
        val words = s.split(' ')
        val rst = mutableListOf<String>()

        val charArray = CharArray(words.size)
        var idx = 0
        while (true) {
            var exist = false
            charArray.fill(' ')
            for ((i, w) in words.withIndex()) {
                if (idx < w.length) {
                    charArray[i] = w[idx]
                    exist = true
                }
            }
            if (exist) rst.add(charArray.joinToString("").trimEnd())
            else break
            idx++
        }

        return rst
    }
}

fun main() {
    println(Solution1324().printVertically("HOW ARE YOU"))
}