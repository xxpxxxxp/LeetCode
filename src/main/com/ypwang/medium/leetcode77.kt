package com.ypwang.medium

class Solution77 {
    fun combine(n: Int, k: Int): List<List<Int>> {
        if (n == k) return listOf((1..n).toList())
        if (k == 1) return (1..n).map { listOf(it) }
        return combine(n - 1, k) + combine(n - 1, k - 1).map { it + n }
    }
}

fun main(args: Array<String>) {
    println(Solution77().combine(4, 2))
}