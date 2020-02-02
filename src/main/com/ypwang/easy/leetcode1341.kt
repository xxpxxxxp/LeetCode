package com.ypwang.easy

class Solution1341 {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray =
        mat.withIndex().map {
            for (i in it.value.indices) {
                if (it.value[i] == 0) return@map it.index to i
            }
            return@map it.index to it.value.size
        }
                .sortedWith(compareBy<kotlin.Pair<Int, Int>>{ it.second }.thenBy{ it.first })
                .take(k)
                .map { it.first }
                .toIntArray()
}

fun main() {
    println(Solution1341().kWeakestRows(arrayOf(
            intArrayOf(1,1,0,0,0), intArrayOf(1,1,1,1,0), intArrayOf(1,0,0,0,0), intArrayOf(1,1,0,0,0), intArrayOf(1,1,1,1,1)
    ), 3).toList())
}