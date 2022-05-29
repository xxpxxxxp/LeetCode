package com.ypwang.medium

class Solution2285 {
    fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
        val arr = IntArray(n)

        for ((a, b) in roads) {
            arr[a]++
            arr[b]++
        }

        arr.sort()
        return arr.withIndex().map { (it.index + 1L) * it.value }.sum()
    }
}