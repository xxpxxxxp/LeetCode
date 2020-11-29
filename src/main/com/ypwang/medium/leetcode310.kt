package com.ypwang.medium

class Solution310 {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        val degree = (0 until n).map{ Pair(it, mutableSetOf<Int>()) }.toMap().toMutableMap()

        for (e in edges) {
            degree[e[0]]!!.add(e[1])
            degree[e[1]]!!.add(e[0])
        }

        while (true) {
            val removals = degree.filter { it.value.size < 2 }
            for ((k, v) in removals) {
                for (vv in v) {
                    degree[vv]!!.remove(k)
                }

                degree.remove(k)
            }
            if (degree.isEmpty())
                return removals.keys.toList()
        }
    }
}

fun main() {
    println(Solution310().findMinHeightTrees(
            6, arrayOf(
            intArrayOf(0,3),
            intArrayOf(1,3),
            intArrayOf(2,3),
            intArrayOf(4,3),
            intArrayOf(5,4)
    )
    ))
}