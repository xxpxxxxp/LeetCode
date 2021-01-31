package com.ypwang.medium

class Solution1743 {
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val map = mutableMapOf<Int, IntArray>()

        for ((i, j) in adjacentPairs) {
            if (i in map)
                map[i]!![1] = j
            else
                map[i] = intArrayOf(j, Int.MAX_VALUE)

            if (j in map)
                map[j]!![1] = i
            else
                map[j] = intArrayOf(i, Int.MAX_VALUE)
        }

        val head = map.filter { it.value[1] == Int.MAX_VALUE }.keys.first()
        val rst = IntArray(adjacentPairs.size + 1)
        rst[0] = head
        for (i in 1 until rst.size) {
            rst[i] = map[rst[i-1]]!!.single { if (i > 1) it != rst[i-2] else it != Int.MAX_VALUE }
        }

        return rst
    }
}