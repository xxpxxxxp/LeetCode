package com.ypwang.medium

class Solution2685 {
    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
        val dsu = IntArray(n) { it }
        val c1 = IntArray(n) { 1 }
        val c2 = IntArray(n)

        fun root(i: Int): Int {
            if (dsu[i] != i)
                dsu[i] = root(dsu[i])

            return dsu[i]
        }

        fun union(i: Int, j: Int) {
            val r1 = root(i)
            val r2 = root(j)
            if (r1 != r2) {
                c1[r2] += c1[r1]
                c2[r2] += c2[r1]
            }
            c2[r2]++
            dsu[r1] = r2
        }

        for ((a, b) in edges)
            union(a, b)

        return dsu.withIndex().filter { it.index == it.value }.map { it.index }.count {
            val x = c1[it]
            c2[it] == x * (x-1) / 2
        }
    }
}

fun main() {
    println(Solution2685().countCompleteComponents(6, arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(1,2), intArrayOf(3,4))))
    println(Solution2685().countCompleteComponents(6, arrayOf(
        intArrayOf(0,1), intArrayOf(0,2), intArrayOf(1,2), intArrayOf(3,4), intArrayOf(3,5)
    )))
}