package com.ypwang.hard

class Solution924 {
    class DSU(val id: Int) {
        var count: Int = 1
        private var parent: DSU = this

        fun findParent(): DSU {
            if (parent != this) {
                parent = parent.findParent()
            }
            return parent
        }

        fun union(that: DSU) {
            findParent().count += that.findParent().parent.count
            that.findParent().parent = findParent()
        }
    }

    fun minMalwareSpread(graph: Array<IntArray>, initial: IntArray): Int {
        val dsus = Array(graph.size){ DSU(it) }

        for (i in 0 until graph.size) {
            for (j in i+1 until graph.size) {
                if (graph[i][j] == 1) {
                    dsus[i].union(dsus[j])
                }
            }
        }

        val ans = IntArray(graph.size)
        for (id in initial) {
            ans[dsus[id].findParent().id]++
        }

        var count = Int.MIN_VALUE
        var the = -1
        for (id in initial) {
            val myCount =
                if (ans[dsus[id].findParent().id] > 1) 1
                else dsus[id].findParent().count
            if (myCount > count || (myCount == count && id < the)) {
                the = id
                count = myCount
            }
        }

        return the
    }
}

fun main() {
    println(Solution924().minMalwareSpread(arrayOf(
        intArrayOf(1,0,0,0,1,0,0,0),intArrayOf(0,1,1,0,0,1,0,0),intArrayOf(0,1,1,0,1,0,0,0),intArrayOf(0,0,0,1,1,0,0,0),intArrayOf(1,0,1,1,1,0,0,1),intArrayOf(0,1,0,0,0,1,0,0),intArrayOf(0,0,0,0,0,0,1,1),intArrayOf(0,0,0,0,1,0,1,1)
    ), intArrayOf(7, 2)))
}