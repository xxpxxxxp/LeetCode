package com.ypwang.medium

import java.util.PriorityQueue

class Solution2208 {
    fun halveArray(nums: IntArray): Int {
        val heap = PriorityQueue<Double>(compareByDescending { it })
        var half = nums.fold(0L) { a, b -> a + b } / 2.0
        heap.addAll(nums.map { it.toDouble() })

        var count = 0
        while (half > 0) {
            count++
            val t = heap.poll()
            half -= t / 2.0
            heap.offer(t / 2.0)
        }

        return count
    }
}

fun main() {
    println(Solution2208().halveArray(intArrayOf(32,98,23,14,67,40,26,9,96,96,91,76,4,40,42,2,31,13,16,37,62,2,27,25,100,94,14,3,48,56,64,59,33,10,74,47,73,72,89,69,15,79,22,18,53,62,20,9,76,64)))
}