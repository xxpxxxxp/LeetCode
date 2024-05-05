package com.ypwang.medium

class Solution3137 {
    fun minimumOperationsToMakeKPeriodic(word: String, k: Int): Int =
        word.length / k - (0 until word.length / k)
            .map { word.substring(it * k, (it+1) * k) }
            .groupBy { it }
            .map { it.value.size }
            .max()!!
}
