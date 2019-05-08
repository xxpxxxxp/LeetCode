package com.ypwang.easy

import java.util.*

class Solution1005 {
    fun largestSumAfterKNegations(A: IntArray, K: Int): Int {
        val q = PriorityQueue<Int>()
        A.forEach { q.add(it) }

        for (i in 0 until K) {
            val t = q.poll()
            q.offer(-t)
        }

        return q.sum()
    }
}