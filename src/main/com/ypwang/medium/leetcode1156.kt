package com.ypwang.medium

class Solution1156 {
    fun maxRepOpt1(text: String): Int {
        val group = mutableListOf<Pair<Char, Int>>()
        var cur = text[0]
        var count = 1
        for (i in 1 until text.length) {
            if (text[i] == cur) count++
            else {
                group.add(cur to count)
                cur = text[i]
                count = 1
            }
        }
        group.add(cur to count)

        val g = group.toTypedArray()

        val counts = text.groupBy { it }.mapValues { it.value.size }.toMap()
        var res = g.map { minOf(it.second+1, counts[it.first]!!) }.max()!!

        for (i in 1 until g.size-1) {
            if (g[i-1].first == g[i+1].first && g[i].second == 1)
                res = maxOf(res, minOf(g[i-1].second + g[i+1].second + 1, counts[g[i-1].first]!!))
        }

        return res
    }
}

fun main() {
    println(Solution1156().maxRepOpt1("aaaaa"))
}