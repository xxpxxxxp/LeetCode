package com.ypwang.easy

class Solution1010 {
    fun numPairsDivisibleBy60(time: IntArray): Int {
        val cache = IntArray(60)

        var count = 0
        for (t in time) {
            val mod = t % 60
            val balance = (60 - mod) % 60
            count += cache[balance]
            cache[mod]++
        }

        return count
    }
}

fun main() {
    println(Solution1010().numPairsDivisibleBy60(intArrayOf(30,20,150,100,40)))
}