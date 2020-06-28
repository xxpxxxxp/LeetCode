package com.ypwang.hard

import java.util.*

class Solution1499 {
    fun findMaxValueOfEquation(points: Array<IntArray>, k: Int): Int {
        val deque: Deque<Int> = LinkedList()
        var rst = Int.MIN_VALUE

        for ((i, arr) in points.withIndex()) {
            val (x, y) = arr
            while (deque.isNotEmpty() && points[deque.first][0] < x - k)
                deque.pollFirst()

            if (deque.isNotEmpty()) {
                val (x1, y1) = points[deque.first]
                rst = maxOf(rst, y1 - x1 + x + y)
            }

            while (deque.isNotEmpty() && points[deque.last].let { it[1] - it[0] } <= y - x)
                deque.pollLast()

            deque.add(i)
        }

        return rst
    }
}