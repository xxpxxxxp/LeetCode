package com.ypwang.medium

import java.util.*

class Solution1792 {
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        val heap = PriorityQueue<Triple<Double, Int, Int>>(compareBy { it.first })
        heap.addAll(classes.map { (a, b) -> Triple(a.toDouble() / b - (a + 1).toDouble() / (b + 1), a, b) })
        for (i in 0 until extraStudents) {
            val (v, a, b) = heap.poll()
            heap.offer(Triple((a+1).toDouble() / (b+1) - (a+2).toDouble() / (b+2), a+1, b+1))
        }

        return heap.map { it.second.toDouble() / it.third }.average()
    }
}