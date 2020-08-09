package com.ypwang.easy

class Solution1539 {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        var max = 0
        var missing = 0

        for (i in arr) {
            val gap = i - max
            if (gap != 1) {
                if (missing + gap <= k)
                    missing += gap - 1
                else
                    return max + k - missing
            }
            max = i
        }

        return arr.last() + k - missing
    }
}

fun main() {
    println(Solution1539().findKthPositive(intArrayOf(8,17,23,34,37,42), 16))
    println(Solution1539().findKthPositive(intArrayOf(2,3,4,7,11), 5))
    println(Solution1539().findKthPositive(intArrayOf(1,2,3,4), 2))
}