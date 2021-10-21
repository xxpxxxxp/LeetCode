package com.ypwang.hard

import java.util.*

class Solution1606 {
    fun busiestServers(k: Int, arrival: IntArray, load: IntArray): List<Int> {
        val counts = IntArray(k)
        val heap = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.first.compareTo(o2.first) }
        val available = TreeSet<Int>()
        for (i in 0 until k)
            available.add(i)

        for (i in arrival.indices) {
            val a = arrival[i]
            val l = load[i]

            while (heap.isNotEmpty() && heap.peek().first <= a) {
                available.add(heap.poll().second)
            }

            if (available.isEmpty())
                continue

            val next = available.ceiling(i % k) ?: available.first()
            heap.add(a + l to next)
            available.remove(next)
            counts[next]++
        }

        val max = counts.maxOrNull()!!
        return counts.withIndex().filter { it.value == max }.map { it.index }
    }
}