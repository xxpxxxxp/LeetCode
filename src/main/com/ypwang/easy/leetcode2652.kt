package com.ypwang.easy

class Solution2652 {
    private val div = listOf(3, 5, 7)
    fun sumOfMultiples(n: Int): Int =
        (1..n).filter { v -> div.any { v % it == 0 } }.sum()
}