package com.ypwang.hard

import java.util.*

class Solution {
    fun findCrossingTime(n: Int, k: Int, time: Array<IntArray>): Int {
        var n = n
        val lBank = PriorityQueue(compareByDescending<Int> { time[it][0] + time[it][2] }.thenByDescending { it })
        val rBank = PriorityQueue(compareByDescending<Int> { time[it][0] + time[it][2] }.thenByDescending { it })

        // 0 -> time of the worker will be waiting to cross the bridge, 1 -> idx
        val lWorker = PriorityQueue<IntArray>(compareBy { it[0] })
        val rWorker = PriorityQueue<IntArray>(compareBy { it[0] })

        // initially, all at left bank
        for (i in 0 until k)
            lBank.add(i)

        var curTime = 0
        while (n > 0) {
            // process worker.
            while (lWorker.isNotEmpty() && lWorker.peek()[0] <= curTime)
                lBank.add(lWorker.poll()[1])
            while (rWorker.isNotEmpty() && rWorker.peek()[0] <= curTime)
                rBank.add(rWorker.poll()[1])
            if (rBank.isNotEmpty()) {
                // right side can pass. A box will be put.
                val worker = rBank.poll()
                val t = time[worker]
                lWorker.add(intArrayOf(curTime + t[2] + t[3], worker))
                curTime += t[2] // right to left.
                n--
            } else if (lBank.isNotEmpty() && n > rWorker.size) {
                // left side can pass.
                // left side only pass when there are more boxes.
                val worker = lBank.poll()
                val t = time[worker]
                rWorker.add(intArrayOf(curTime + t[0] + t[1], worker))
                curTime += t[0] // left to right.
            } else if (n == rWorker.size) {
                curTime = rWorker.peek()[0]
            } else {
                // if still empty, advance time.
                curTime = if (rWorker.isEmpty())
                    lWorker.peek()[0]
                else if (lWorker.isEmpty())
                    rWorker.peek()[0]
                else minOf(lWorker.peek()[0], rWorker.peek()[0])
            }
        }
        return curTime
    }
}
