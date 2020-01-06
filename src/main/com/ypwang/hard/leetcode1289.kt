package com.ypwang.hard

import java.util.*

class Solution1289 {
    fun take(arr: Iterable<IndexedValue<Int>>): Array<IndexedValue<Int>> {
        val p = PriorityQueue<IndexedValue<Int>>(Comparator{ i1, i2 -> i2.value - i1.value })
        for (kv in arr) {
            p.offer(kv)
            if (p.size > 2) p.poll()
        }

        return p.toTypedArray()
    }


    fun minFallingPathSum(arr: Array<IntArray>): Int {
        var (big, small) = take(arr[0].withIndex())
        for (i in 1 until arr.size) {
            var (b, s) = take(arr[i].withIndex())
            val next = mutableListOf<IndexedValue<Int>>()
            next.add(IndexedValue(small.index, arr[i][small.index] + big.value))
            if (b.index != small.index) next.add(IndexedValue(b.index, b.value + small.value))
            if (s.index != small.index) next.add(IndexedValue(s.index, s.value + small.value))

            val t = take(next)
            big = t[0]
            small = t[1]
        }

        return small.value
    }
}

fun main() {
    println(Solution1289().minFallingPathSum(arrayOf(
            intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)
    )))
}