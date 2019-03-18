package com.ypwang.medium

class Solution275 {
    fun hIndex(citations: IntArray): Int {
        for (i in 0 until citations.size) {
            if (citations[citations.lastIndex-i] >= i + 1 && (i + 1 == citations.size || citations[citations.lastIndex-i-1] < i + 2)) {
                return i + 1
            }
        }

        return 0
    }
}

fun main() {
    println(Solution275().hIndex(intArrayOf(0,1,3,5,6)))
}