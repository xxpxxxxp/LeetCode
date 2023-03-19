package com.ypwang.easy

class Solution2595 {
    fun evenOddBit(n: Int): IntArray {
        val (even, odd) = n.toString(2)
            .reversed()
            .withIndex()
            .filter { it.value == '1' }
            .partition { it.index % 2 == 0 }

        return intArrayOf(even.size, odd.size)
    }
}

fun main() {
    println(Solution2595().evenOddBit(2))
}