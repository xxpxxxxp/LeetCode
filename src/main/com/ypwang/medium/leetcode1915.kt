package com.ypwang.medium

class Solution1915 {
    fun wonderfulSubstrings(word: String): Long {
        val count = mutableMapOf<Int, Int>(0 to 1)
        var rst = 0L

        var mask = 0
        for (c in word) {
            mask = mask xor (1 shl (c - 'a'))
            val j = count.getOrDefault(mask, 0)
            rst += j

            for (i in 0 until 10) {
                rst += count.getOrDefault(mask xor (1 shl i), 0)
            }

            count[mask] = j + 1
        }

        return rst
    }
}

fun main() {
    println(Solution1915().wonderfulSubstrings("aba"))
    println(Solution1915().wonderfulSubstrings("aabb"))
    println(Solution1915().wonderfulSubstrings("he"))
}