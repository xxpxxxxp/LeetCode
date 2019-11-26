package com.ypwang.medium

class Solution1238 {
    fun circularPermutation(n: Int, start: Int): List<Int> {
        val gray = (1 until n).fold(listOf(0, 1)){ cur, i ->
            cur + cur.reversed().map { it or (1 shl i) }
        }.toMutableList()

        while (gray.first() != start) {
            gray.add(gray.removeAt(0))
        }

        return gray
    }
}

fun main() {
    println(Solution1238().circularPermutation(2,3))
    println(Solution1238().circularPermutation(3,2))
}