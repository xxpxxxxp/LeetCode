package com.ypwang.medium

class Solution2070 {
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        items.sortBy { it[0] }

        var i = 0
        var max = 0
        val rst = IntArray(queries.size)
        for ((idx, v) in queries.withIndex().sortedBy { it.value }) {
            while (i < items.size && items[i][0] <= v) {
                max = maxOf(max, items[i][1])
                i++
            }

            rst[idx] = max
        }

        return rst
    }
}