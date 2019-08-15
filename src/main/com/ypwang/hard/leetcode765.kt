package com.ypwang.hard

class Solution765 {
    private class DSU {
        private var parent = this

        fun Parent(): DSU {
            if (parent != this) parent = parent.Parent()
            return parent
        }

        fun Union(that: DSU) {
            this.Parent().parent = that.Parent()
        }
    }

    fun minSwapsCouples(row: IntArray): Int {
        val dsus = Array(row.size){ DSU() }

        for (i in 0 until dsus.size step 2) {
            dsus[i].Union(dsus[i+1])
            dsus[row[i]].Union(dsus[row[i+1]])
        }

        return (row.size / 2) - dsus.count { it.Parent() == it }
    }
}

fun main() {
    println(Solution765().minSwapsCouples(intArrayOf(0, 2, 1, 3)))
    println(Solution765().minSwapsCouples(intArrayOf(3, 2, 0, 1)))
}