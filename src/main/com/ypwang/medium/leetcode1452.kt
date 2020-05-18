package com.ypwang.medium

class Solution1452 {
    fun peopleIndexes(favoriteCompanies: List<List<String>>): List<Int> {
        val candidates = mutableMapOf<String, MutableSet<Int>>()

        val rst = mutableListOf<Int>()
        for ((i, cs) in favoriteCompanies.withIndex().sortedByDescending { it.value.size }) {
            var c: Set<Int>? = candidates[cs[0]]

            for (s in cs) {
                if (c == null || c.isEmpty()) break
                c = candidates[s]?.intersect(c)?.toSet()
            }

            if (c == null || c.isEmpty()) rst.add(i)
            cs.forEach{ candidates.getOrPut(it, { mutableSetOf() }).add(i) }
        }

        return rst.sorted()
    }
}

fun main() {
    println(Solution1452().peopleIndexes(listOf(
            listOf("leetcode","google","facebook"), listOf("google","microsoft"), listOf("google","facebook"), listOf("google"), listOf("amazon")
    )))
}