package com.ypwang.medium

class Solution2121 {
    fun getDistances(arr: IntArray): LongArray {
        val rst = LongArray(arr.size)

        arr.withIndex()
            .groupBy { it.value }
            .map { it.value.map { kv -> kv.index } }
            .forEach { group ->
                var sum = group.map { it.toLong() }.sum()

                var base = 0
                var l = 0
                var r = group.size

                for ((i, idx) in group.withIndex()) {
                    sum += (l - r) * (idx - base)
                    rst[idx] = sum
                    l++
                    r--
                    base = idx
                }
            }

        return rst
    }
}
