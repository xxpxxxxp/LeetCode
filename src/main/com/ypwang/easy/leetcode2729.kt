package com.ypwang.easy

class Solution2729 {
    fun isFascinating(n: Int): Boolean {
        val c = IntArray(10)
        (n.toString() + (2 * n).toString() + (3 * n).toString()).forEach { c[it - '0']++ }
        c[0]++
        return c.all { it == 1 }
    }
}