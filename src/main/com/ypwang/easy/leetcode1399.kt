package com.ypwang.easy

class Solution1399 {
    fun countLargestGroup(n: Int): Int {
        val cache = IntArray(37)
        for (c in 1..n) {
            var t = c
            var r = 0
            while (t > 0) {
                r += t % 10
                t /= 10
            }
            cache[r]++
        }

        val max = cache.filter { it != 0 }.max()!!
        return cache.count { it == max }
    }
}

fun main() {
    println(Solution1399().countLargestGroup(13))
    println(Solution1399().countLargestGroup(24))
}