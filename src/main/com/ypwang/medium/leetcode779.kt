package com.ypwang.medium

class Solution779 {
    fun kthGrammar(N: Int, K: Int): Int = (K-1).toString(2).asSequence().map { it - '0' }.reduce { acc, i -> acc xor i }
}

fun main() {
    println(Solution779().kthGrammar(1, 1))
    println(Solution779().kthGrammar(2, 1))
    println(Solution779().kthGrammar(2, 2))
    println(Solution779().kthGrammar(4, 5))
}