package com.ypwang.medium

import java.util.*

class Solution1705 {
    fun eatenApples(apples: IntArray, days: IntArray): Int {
        // int array: rot day, number
        val heap = PriorityQueue<IntArray>(compareBy { it[0] })

        var eat = 0
        for (i in apples.indices) {
            heap.add(intArrayOf(i + days[i], apples[i]))
            while (heap.isNotEmpty() && heap.peek().let { it[1] == 0 || it[0] <= i })
                heap.poll()

            if (heap.isNotEmpty()) {
                heap.peek()[1]--
                eat++
            }
        }

        var day = apples.size
        while (heap.isNotEmpty()) {
            val top = heap.poll()
            if (top[0] > day) {
                day += minOf(top[0] - day, top[1])
            }
        }

        return eat + day - apples.size
    }
}

fun main() {
    println(Solution1705().eatenApples(intArrayOf(1,2,3,5,2), intArrayOf(3,2,1,4,2)))
    println(Solution1705().eatenApples(intArrayOf(3,0,0,0,0,2), intArrayOf(3,0,0,0,0,2)))
}