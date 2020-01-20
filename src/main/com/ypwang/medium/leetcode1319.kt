package com.ypwang.medium

class Solution1319 {
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        val dsu = IntArray(n){ it }
        var redundant = 0

        fun parent(i: Int): Int {
            if (dsu[i] != i) dsu[i] = parent(dsu[i])
            return dsu[i]
        }

        fun union(a: Int, b: Int): Boolean {
            val pa = parent(a)
            val pb = parent(b)
            return if (pa == pb) true
            else {
                dsu[pa] = pb
                false
            }
        }

        for ((a, b) in connections) {
            if (union(a, b)) redundant++
        }

        return (dsu.withIndex().count { it.index == it.value } - 1).let { if (it <= redundant) it else -1 }
    }
}

fun main() {
    println(Solution1319().makeConnected(4, arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(1,2))))
}