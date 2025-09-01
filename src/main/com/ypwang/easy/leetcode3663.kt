package com.ypwang.easy

class Solution3663 {
    fun getLeastFrequentDigit(n: Int): Int {
        val c = n.toString().groupBy { it }.mapValues { it.value.size }
        val m = c.values.min()
        return c.filter { it.value == m }.map { it.key }.min() - '0'
    }
}
