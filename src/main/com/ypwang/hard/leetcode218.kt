package com.ypwang.hard

import java.util.*

class Solution218 {
    fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
        buildings.sortWith(Comparator{ i1, i2 ->
            if (i1[0] == i2[0]) i2[2].compareTo(i1[2])
            else i1[0].compareTo(i2[0])
        })

        val heap = PriorityQueue<Pair<Int, Int>>(Comparator { p1, p2 -> p2.second.compareTo(p1.second) })
        val rst = mutableListOf<List<Int>>()

        for ((l, r, h) in buildings) {
            while (heap.isNotEmpty() && heap.peek().first < l) {
                val (x, y) = heap.poll()
                while (heap.isNotEmpty() && heap.peek().first <= x)
                    heap.poll()

                val n = if (heap.isEmpty()) 0 else heap.peek().second
                if (y != n) rst.add(listOf(x, n))
            }

            if (heap.isEmpty() || heap.peek().second < h) rst.add(listOf(l, h))
            heap.offer(r to h)
        }

        while (heap.isNotEmpty()) {
            val (x, y) = heap.poll()
            while (heap.isNotEmpty() && heap.peek().first <= x)
                heap.poll()

            val n = if (heap.isEmpty()) 0 else heap.peek().second
            if (y != n) rst.add(listOf(x, n))
        }

        return rst
    }
}

fun main() {
    println(Solution218().getSkyline(arrayOf(
            intArrayOf(1,2,1), intArrayOf(1,2,2), intArrayOf(1,2,3)
    )))
    println(Solution218().getSkyline(arrayOf(
            intArrayOf(0,2,3), intArrayOf(2,5,3)
    )))
    println(Solution218().getSkyline(arrayOf(
            intArrayOf(2,9,10), intArrayOf(3,7,15), intArrayOf(5,12,12), intArrayOf(15,20,10), intArrayOf(19,24,8)
    )))
}