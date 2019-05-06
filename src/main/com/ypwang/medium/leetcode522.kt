package com.ypwang.medium

class Solution522 {
    private fun isSubSequence(bigger: String, smaller: String): Boolean {
        var b = 0
        var s = 0

        while (b < bigger.length && s < smaller.length) {
            if (bigger[b] == smaller[s]) s++
            b++
        }

        return s == smaller.length
    }

    fun findLUSlength(strs: Array<String>): Int {
        val group = strs.groupBy { it }.mapValues { it.value.size }.toList().groupBy { it.first.length }.toList().sortedByDescending { it.first }
        if (group.first().second.any { it.second == 1 }) return group.first().first

        val checks = group.first().second.map { it.first }.toMutableList()
        for ((idx, g) in  group.withIndex()) {
            if (idx == 0) continue

            for ((w, c) in g.second) {
                if (c > 1) checks.add(w)
                else {
                    if (checks.all { !isSubSequence(it, w) }) return w.length
                    checks.add(w)
                }
            }
        }

        return -1
    }
}

fun main() {
    println(Solution522().findLUSlength(arrayOf("aba", "cdc", "eae")))
}