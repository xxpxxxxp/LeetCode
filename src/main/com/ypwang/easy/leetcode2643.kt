package com.ypwang.easy

class Solution2643 {
    fun rowAndMaximumOnes(mat: Array<IntArray>): IntArray =
        mat.withIndex()
            .map { intArrayOf(it.index, it.value.sum()) }
            .maxBy { it[1] }
}