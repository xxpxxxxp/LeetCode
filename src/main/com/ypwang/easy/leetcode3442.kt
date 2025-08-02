package com.ypwang.easy

class Solution3442 {
    fun maxDifference(s: String): Int {
        val freq = s.groupBy { it }.map { it.value.size }
        val (o, e) = freq.partition { it % 2 == 1 }
        return o.max()!! - e.min()!!
    }
}
