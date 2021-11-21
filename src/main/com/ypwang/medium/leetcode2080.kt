package com.ypwang.medium

import java.util.*

class RangeFreqQuery(arr: IntArray) {
    val map = mutableMapOf<Int, TreeMap<Int, Int>>()

    init {
        for ((i, v) in arr.withIndex())
            map.getOrPut(v, { TreeMap() })[i] = map[v]?.size ?: 0
    }

    fun query(left: Int, right: Int, value: Int): Int {
        if (value !in map)
            return 0

        val idxs = map[value]!!
        val a = idxs.ceilingKey(left)
        val b = idxs.floorKey(right)
        return if (a == null || b == null) 0 else idxs[b]!! - idxs[a]!! + 1
    }
}
