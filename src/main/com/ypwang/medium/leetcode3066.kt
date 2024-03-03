package com.ypwang.medium

import java.util.PriorityQueue

class Solution3066 {
    fun minOperations(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Long>()
        nums.forEach { heap.add(it.toLong()) }

        var c = 0
        while (true) {
            val x = heap.poll()
            if (x >= k)
                return c

            val y = heap.poll()
            heap.add(2 * x + y)
            c++
        }
    }
}

fun main() {
    println(Solution3066().minOperations(intArrayOf(999999999,999999999,999999999), 1000000000))
}