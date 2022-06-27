package com.ypwang.medium

class Solution2316 {
    fun countPairs(n: Int, edges: Array<IntArray>): Long {
        val dsu = IntArray(n){it}

        fun root(i: Int): Int {
            if (dsu[i] != i)
                dsu[i] = root(dsu[i])

            return dsu[i]
        }

        fun union(i: Int, j: Int) {
            dsu[root(i)] = root(j)
        }

        edges.forEach { (i, j) -> union(i, j) }
        val cnt = IntArray(n)
        for (i in 0 until n)
            cnt[root(i)]++

        return cnt.map { it.toLong() * (n - it) }.sum() / 2
    }
}

fun main() {
    println(Solution2316().countPairs(3, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2))))
}