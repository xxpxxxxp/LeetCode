package com.ypwang.hard

class Solution928 {
    fun minMalwareSpread(graph: Array<IntArray>, initial: IntArray): Int {
        /* 0: not infected
           i: infected by i
           Int.MAX_VALUE: infected by multiple
         */
        val infected = IntArray(graph.size)
        initial.forEach { infected[it] = -1 }

        val seen = mutableSetOf<Int>()
        fun dfs(i: Int, v: Int) {
            if (i in seen) return
            seen.add(i)
            if (i != v) infected[i] = if (infected[i] == 0) v else Int.MAX_VALUE
            for ((j, _) in graph[i].withIndex().filter { it.value == 1 && infected[it.index] != -1 }) {
                dfs(j, if (i == v) v else infected[i])
            }
        }

        for (i in initial) {
            seen.clear()
            dfs(i, i)
        }

        return infected.withIndex().filter { it.value !in setOf(-1, 0, Int.MAX_VALUE) }.groupBy { it.value }
                .mapValues { it.value.size }.toList().sortedBy { it.first }.maxBy { it.second }?.first ?: initial.min()!!
    }
}

fun main() {
    println(Solution928().minMalwareSpread(arrayOf(intArrayOf(1,1,0,0,0,0,0,0,0,0),intArrayOf(1,1,0,0,0,0,0,0,0,0),intArrayOf(0,0,1,0,0,0,0,0,0,0),intArrayOf(0,0,0,1,0,0,1,0,0,1),intArrayOf(0,0,0,0,1,0,0,0,0,0),intArrayOf(0,0,0,0,0,1,0,0,0,0),intArrayOf(0,0,0,1,0,0,1,0,0,0),intArrayOf(0,0,0,0,0,0,0,1,0,0),intArrayOf(0,0,0,0,0,0,0,0,1,0),intArrayOf(0,0,0,1,0,0,0,0,0,1)), intArrayOf(2,1,9)))
    println(Solution928().minMalwareSpread(arrayOf(intArrayOf(1,1,1,0), intArrayOf(1,1,0,0), intArrayOf(1,0,1,0), intArrayOf(0,0,0,1)), intArrayOf(3,2)))
    println(Solution928().minMalwareSpread(arrayOf(intArrayOf(1,1,0), intArrayOf(1,1,0), intArrayOf(0,0,1)), intArrayOf(0,1)))
    println(Solution928().minMalwareSpread(arrayOf(intArrayOf(1,1,0), intArrayOf(1,1,1), intArrayOf(0,1,1)), intArrayOf(0,1)))
    println(Solution928().minMalwareSpread(arrayOf(intArrayOf(1,1,0,0), intArrayOf(1,1,1,0), intArrayOf(0,1,1,1), intArrayOf(0,0,1,1)), intArrayOf(0,1)))
}