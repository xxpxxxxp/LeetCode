package com.ypwang.easy

class Solution3692 {
    fun majorityFrequencyGroup(s: String): String {
        val g = s.groupBy { it }.mapValues { it.value.size }
        val gg = g.toList().groupBy { it.second }.mapValues { it.value.map { kv -> kv.first }.toSet() }
        val m = gg.maxWith(compareBy<Map.Entry<Int, Set<Char>>> { it.value.size }.thenBy { it.key }).key
        return gg[m]!!.joinToString("")
    }
}
