package com.ypwang.easy

class Solution2578 {
    fun splitNum(num: Int): Int {
        val n = num.toString().toCharArray().sorted().filter { it != '0' }
        return (n.withIndex().filter { it.index % 2 == 0 }.map { it.value }.joinToString("").toIntOrNull() ?: 0) +
        (n.withIndex().filter { it.index % 2 == 1 }.map { it.value }.joinToString("").toIntOrNull() ?: 0)
    }
}