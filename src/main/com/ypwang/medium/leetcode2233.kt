package com.ypwang.medium

import java.util.PriorityQueue

class Solution2233 {
    fun maximumProduct(nums: IntArray, k: Int): Int {
        if (nums.size == 1)
            return nums.single() + k

        val heap = PriorityQueue<Int>()
        heap.addAll(nums.toList())

        var k = k
        while (k > 0) {
            val p = heap.poll()
            val q = heap.peek()
            val diff = minOf(k, q - p + 1)
            k -= diff
            heap.add(p + diff)
        }

        return heap.fold(1L) { a, b -> a * b % 1000000007 }.toInt()
    }
}

fun main() {
    println(Solution2233().maximumProduct(intArrayOf(0,4), 5))
}