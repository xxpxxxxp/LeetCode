package com.ypwang.hard

class Solution1830 {
    fun makeStringSorted(s: String): Int {
        val mod = 1000000007
        val count = IntArray(26)
        var ans = 0L
        var total = 0
        var combination = 1L

        for (c in s.reversed()) {
            val j = c - 'a'
            count[j]++
            total++
            combination = combination * total / count[j]
            ans += (combination * (0 until j).sumBy { count[it] }) / total
        }

        return (ans % mod).toInt()
    }
}

fun main() {
    println(Solution1830().makeStringSorted("jensgfyynhtwlgnoxkkkiguizadmz"))
    println(Solution1830().makeStringSorted("cba"))
    println(Solution1830().makeStringSorted("aabaa"))
    println(Solution1830().makeStringSorted("cdbea"))
    println(Solution1830().makeStringSorted("leetcodeleetcodeleetcode"))
}