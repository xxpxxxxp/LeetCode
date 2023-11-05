package com.ypwang.medium

class Solution2924 {
    fun findChampion(n: Int, edges: Array<IntArray>): Int {
        val inD = IntArray(n)

        for ((_, b) in edges)
            inD[b]++

        val champions = inD.withIndex().filter { it.value == 0 }
        return if (champions.size == 1) champions.first().index else -1
    }
}