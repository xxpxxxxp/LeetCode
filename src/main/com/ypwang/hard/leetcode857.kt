package com.ypwang.hard

import java.util.*

class Solution857 {
    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, K: Int): Double {
        val heap = PriorityQueue<Int>(kotlin.Comparator { a, b -> b - a })

        var rst = Double.MAX_VALUE
        var sum = 0

        for ((w, r) in wage.zip(quality).sortedBy { it.first.toDouble() / it.second }) {
            heap.add(r)
            sum += r
            if (heap.size > K) sum -= heap.poll()
            if (heap.size == K) rst = minOf(rst, sum * w.toDouble() / r)
        }

        return rst
    }
}

fun main() {
    println(Solution857().mincostToHireWorkers(intArrayOf(10,20,5), intArrayOf(70,50,30), 2))
}