package com.ypwang.medium

class Solution3085 {
    fun minimumDeletions(word: String, k: Int): Int {
        val c = word.groupBy { it }.map { it.value.size }.sorted()
        var rst = Int.MAX_VALUE

        var sum = 0

        for (min in c) {
            var t = sum
            for (v in c.reversed()) {
                if (v - min <= k)
                    break

                t += v - min - k
            }
            rst = minOf(rst, t)
            sum += min
        }

        return rst
    }
}

fun main() {
    println(Solution3085().minimumDeletions("zzfzzzzppfp", 1))
    println(Solution3085().minimumDeletions("dabdcbdcdcd", 2))
    println(Solution3085().minimumDeletions("aabcaba", 0))
    println(Solution3085().minimumDeletions("itatwtiwwi", 1))
}