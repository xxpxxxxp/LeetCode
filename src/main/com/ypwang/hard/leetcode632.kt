package com.ypwang.hard

import java.util.*

class Solution632 {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        val iters = nums.map { it.iterator() }.toTypedArray()
        val heap = PriorityQueue<Pair<Int, Int>>{ a, b -> a.first - b.first }

        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE

        for ((i, iter) in iters.withIndex()) {
            if (iter.hasNext()) {
                val n = iter.next()
                heap.add(n to i)

                if (n < min) min = n
                if (n > max) max = n
            }
        }

        var range = min to max

        while (true) {
            val head = heap.poll()
            if (!iters[head.second].hasNext()) break

            val next = iters[head.second].next()
            heap.add(next to head.second)
            if (next > max) max = next
            if (max - heap.peek().first < range.second - range.first) range = heap.peek().first to max
        }

        return intArrayOf(range.first, range.second)
    }
}

fun main() {
    println(Solution632().smallestRange(listOf(
            listOf(4,10,15,24,26), listOf(0,9,12,20), listOf(5,18,22,30)
    )).toList())
}