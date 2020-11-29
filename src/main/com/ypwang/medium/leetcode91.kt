package com.ypwang.medium

class Solution91 {
    fun numDecodings(s: String): Int {
        if (s.isEmpty())
            return 0

        val num = s.map { it.toInt() - '0'.toInt() }
        val way = Array(num.size){0}

        way[0] = if (num[0] == 0) 0 else 1

        for (i in 1 until num.size) {
            if (num[i] > 0) {
                way[i] += way[i-1]
            }

            if (num[i-1] * 10 + num[i] in 10..26) {
                way[i] += if (i == 1) 1 else way[i-2]
            }
        }
        return way.last()
    }
}

fun main() {
    println(Solution91().numDecodings("10"))
}