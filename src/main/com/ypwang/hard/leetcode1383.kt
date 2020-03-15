package com.ypwang.hard

import java.util.*

class Solution1383 {
    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
        val zipped = speed.zip(efficiency).sortedByDescending { it.second }
        val heap = PriorityQueue<Int>()

        var rst = 0L
        var sum = 0L
        for ((i, kv) in zipped.withIndex()) {
            val (s, e) = kv
            if (i < k) {
                sum += s
                rst = maxOf(rst, sum * e)
                heap.add(s)
            } else {
                if (s > heap.peek()) {
                    sum -= heap.poll()
                    sum += s
                    rst = maxOf(rst, sum * e)
                    heap.add(s)
                }
            }
        }

        return (rst % 1000000007).toInt()
    }
}

fun main() {
    println(Solution1383().maxPerformance(6, intArrayOf(2,10,3,1,5,8), intArrayOf(5,4,3,9,7,2), 2))
    println(Solution1383().maxPerformance(6, intArrayOf(2,10,3,1,5,8), intArrayOf(5,4,3,9,7,2), 3))
    println(Solution1383().maxPerformance(6, intArrayOf(2,10,3,1,5,8), intArrayOf(5,4,3,9,7,2), 4))
}