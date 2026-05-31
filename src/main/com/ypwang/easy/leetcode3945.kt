package com.ypwang.easy

class Solution3945 {
    fun digitFrequencyScore(n: Int): Int =
        n.toString().groupBy { it }.map { (it.key - '0') * it.value.size }.sum()
}
