package com.ypwang.hard

class Solution1639 {
    private val mod = 1000000007

    fun numWays(words: Array<String>, target: String): Int {
        val len = words[0].length
        val cache = Array(len) { idx ->
            val t = IntArray(26)
            words.map { it[idx] }.groupBy { it }.forEach { t[it.key-'a'] = it.value.size }
            t
        }

        return (1 until target.length).fold(IntArray(len) { cache[it][target[0]-'a'] }) { dp, i ->
            val next = IntArray(len)

            var sum = 0
            for (j in 0 until len) {
                if (j >= i) {
                    next[j] = ((cache[j][target[i]-'a'] * sum.toLong()) % mod).toInt()
                }
                sum = (sum + dp[j]) % mod
            }

            next
        }.reduce { acc, i -> (acc + i) % mod }
    }
}

fun main() {
    println(Solution1639().numWays(
            arrayOf("bbd","daa","dbd"), "da"
    ))

    println(Solution1639().numWays(
            arrayOf("acca","bbbb","caca"), "aba"
    ))

    println(Solution1639().numWays(
            arrayOf("abba","baab"), "bab"
    ))
}