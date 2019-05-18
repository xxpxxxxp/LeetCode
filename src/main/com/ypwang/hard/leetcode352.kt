package com.ypwang.hard

import java.util.TreeMap

class SummaryRanges {
    val tree: TreeMap<Int, IntArray> = TreeMap()

    fun getIntervals(): Array<IntArray> = tree.values.toTypedArray()
    fun addNum(`val`: Int) {
        if (tree.containsKey(`val`)) return
        val l = tree.lowerKey(`val`)
        val h = tree.higherKey(`val`)
        if (l != null && h != null && tree[l]!![1] + 1 == `val` && h == `val` + 1) {
            tree[l]!![1] = tree[h]!![1]
            tree.remove(h)
        } else if (l != null && tree[l]!![1] + 1 == `val`) {
            tree[l]!![1] = `val`
        } else if (h != null && h == `val` + 1) {
            tree[`val`] = intArrayOf(`val`, tree[h]!![1])
            tree.remove(h)
        } else {
            tree[`val`] = intArrayOf(`val`, `val`)
        }
    }
}