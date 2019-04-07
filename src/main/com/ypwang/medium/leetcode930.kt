package com.ypwang.medium

class Solution930 {
    fun numSubarraysWithSum(A: IntArray, S: Int): Int {
        val h = mutableMapOf(S to 1)
        var sum = 0
        var count = 0

        for (a in A) {
            sum += a
            count += h.getOrDefault(sum, 0)
            h[sum + S] = h.getOrDefault(sum + S, 0) + 1
        }
        return count
    }
}

fun main() {
    println(Solution930().numSubarraysWithSum(intArrayOf(0,0,0,0,0), 0))
}