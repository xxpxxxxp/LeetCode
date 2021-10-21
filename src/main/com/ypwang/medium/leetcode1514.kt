package com.ypwang.medium

class Solution1514 {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int, end: Int): Double {
        val map = mutableMapOf<Int, MutableList<Int>>()
        for ((i, e) in edges.withIndex()) {
            val (a, b) = e
            map.getOrPut(a, { mutableListOf() }).add(i)
            map.getOrPut(b, { mutableListOf() }).add(i)
        }

        val p = mutableMapOf(start to 1.0)
        val seen = mutableSetOf(start)
        while (p.isNotEmpty()) {
            val (i, v) = p.maxByOrNull { it.value }!!
            if (i == end) return v
            p.remove(i)
            seen.add(i)

            if (i in map) {
                for (j in map[i]!!) {
                    val next = edges[j].fold(i){ acc, c -> acc xor c }
                    if (next !in seen) {
                        p[next] = maxOf(p.getOrDefault(next, 0.0), v * succProb[j])
                    }
                }
            }
        }

        return 0.0
    }
}

fun main() {
    println(Solution1514().maxProbability(3, arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(0,2)),
    doubleArrayOf(0.5,0.5,0.2), 0, 2))
}