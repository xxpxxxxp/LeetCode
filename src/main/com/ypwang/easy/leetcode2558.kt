package com.ypwang.easy

import java.util.*

class Solution2558 {
    fun pickGifts(gifts: IntArray, k: Int): Long {
        val pq = PriorityQueue<Int>(compareByDescending { it })
        pq.addAll(gifts.toList())
        for (i in 0 until k) {
            pq.add(Math.floor(Math.sqrt(pq.poll().toDouble())).toInt())
        }
        return pq.fold(0L) { a, b -> a + b }
    }
}