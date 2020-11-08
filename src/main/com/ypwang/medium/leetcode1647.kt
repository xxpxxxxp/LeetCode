package com.ypwang.medium

class Solution1647 {
    fun minDeletions(s: String): Int {
        val count = s
                .groupBy { it }
                .mapValues { it.value.size }
                .toList()
                .groupBy { it.second }
                .mapValues { it.value.size }
                .toList()
                .sortedByDescending { it.first }
        val taken = count.map { it.first }.toMutableSet()
        var available = Int.MAX_VALUE
        var rst = 0

        for ((freq, c) in count) {
            for (x in 1 until c) {
                available = minOf(available, freq)
                while (available > 0 && available in taken) {
                    available--
                }
                taken.add(available)
                rst += freq - available
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1647().minDeletions("accdcdadddbaadbc"))
    println(Solution1647().minDeletions("aab"))
    println(Solution1647().minDeletions("aaabbbcc"))
    println(Solution1647().minDeletions("ceabaacb"))
}