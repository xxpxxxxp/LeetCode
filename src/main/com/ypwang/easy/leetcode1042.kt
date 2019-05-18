package com.ypwang.easy

class Solution1042 {
    fun gardenNoAdj(N: Int, paths: Array<IntArray>): IntArray {
        val relation = paths.map { maxOf(it[0], it[1]) to minOf(it[0], it[1]) }
                .groupBy { it.first }.mapValues { it.value.map { it.second } }

        val rst = IntArray(N)
        for (i in 0 until N) {
            val t = relation.getOrDefault(i+1, listOf()).map { rst[it-1] }.toSet()
            for (j in 1..4) {
                if (j !in t) {
                    rst[i] = j
                    break
                }
            }
        }

        return rst
    }
}