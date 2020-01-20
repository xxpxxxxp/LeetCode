package com.ypwang.hard

class Solution1326 {
    fun minTaps(n: Int, ranges: IntArray): Int {
        var left = 0
        var end = -1000
        var cnt = 1
        for ((l, r) in ranges.withIndex()
                .map { it.index - it.value to it.index + it.value }
                .sortedBy { it.first }) {
            if (l > left) {
                if (l > end) return -1
                cnt++
                left = end
            } else if (r <= end) continue
            end = r
            if (end >= n) return cnt
        }

        return -1
    }
}

fun main() {
    println(Solution1326().minTaps(5, intArrayOf(3,4,1,1,0,0)))
    println(Solution1326().minTaps(3, intArrayOf(0,0,0,0)))
    println(Solution1326().minTaps(7, intArrayOf(1,2,1,0,2,1,0,1)))
    println(Solution1326().minTaps(8, intArrayOf(4,0,0,0,0,0,0,0,4)))
    println(Solution1326().minTaps(8, intArrayOf(4,0,0,0,4,0,0,0,4)))
}