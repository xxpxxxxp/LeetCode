package com.ypwang.easy

class Solution438 {
    fun findAnagrams(s: String, p: String): List<Int> {
        val rst = mutableListOf<Int>()
        if (s.length < p.length) {
            return rst
        }
        val ph = p.groupBy { it }.mapValues { it.value.size }
        val sh = s.take(p.length).groupBy { it }.mapValues { it.value.size }.toMutableMap()
        if (sh == ph) {
            rst.add(0)
        }
        for (i in p.length until s.length) {
            val c = s[i - p.length]
            sh[c] = sh[c]!! - 1
            if (sh[c] == 0) {
                sh.remove(c)
            }
            sh[s[i]] = sh.getOrDefault(s[i], 0) + 1

            if (sh == ph) {
                rst.add(i - p.length + 1)
            }
        }
        return rst
    }
}

fun main() {
    Solution438().findAnagrams("cbaebabacd", "abc")
}
