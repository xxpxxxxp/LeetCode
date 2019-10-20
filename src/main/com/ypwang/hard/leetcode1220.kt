package com.ypwang.hard

class Solution1220 {
    fun countVowelPermutation(n: Int): Int {
        if (n == 1) return 5

        val mod = 1000000007
        val idx = mapOf('a' to 0, 'e' to 1, 'i' to 2, 'o' to 3, 'u' to 4)
        val choose = mapOf(0 to "e", 1 to "ai", 2 to "aeou", 3 to "iu", 4 to "a")

        return (1 until n).fold(IntArray(5){1}) { cur, _ ->
            IntArray(5).apply {
                (0 until 5).forEach {
                    choose.getValue(it).forEach { c ->
                        val id = idx.getValue(c)
                        this[id] = (this[id] + cur[it]) % mod
                    }
                }
            }
        }.reduce { a, b -> (a + b) % mod }
    }
}

fun main() {
    println(Solution1220().countVowelPermutation(5))
}