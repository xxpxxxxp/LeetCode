package com.ypwang.hard

import java.util.*

class Solution2569 {
    fun handleQuery(nums1: IntArray, nums2: IntArray, queries: Array<IntArray>): LongArray {
        val rst = mutableListOf<Long>()
        val bs = BitSet(nums1.size)
        nums1.withIndex().forEach { (i, v) ->
            if (v == 1)
                bs.set(i)
        }
        var sum = nums2.fold(0L) { a, b -> a + b }
        for ((t, l, r) in queries) {
            when (t) {
                1 -> bs.flip(l, r+1)
                2 -> sum += l.toLong() * bs.cardinality()
                else -> rst.add(sum)
            }
        }
        return rst.toLongArray()
    }
}