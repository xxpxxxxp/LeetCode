package com.ypwang.medium

class Solution274 {
    fun hIndex(citations: IntArray): Int {
        citations.sortDescending()
        for (i in 0 until citations.size) {
            if (citations[i] >= i + 1 && (i + 1 == citations.size || citations[i+1] < i + 2)) {
                return i + 1
            }
        }

        return 0
    }
}

fun main() {
    println(Solution274().hIndex(intArrayOf(1)))
}