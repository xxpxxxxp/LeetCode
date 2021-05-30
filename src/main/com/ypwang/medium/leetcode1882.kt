package com.ypwang.medium

import java.util.*

class Solution1882 {
    fun assignTasks(servers: IntArray, tasks: IntArray): IntArray {
        val serverHeap = PriorityQueue(compareBy<Int> { servers[it] }.thenBy{ it })
        serverHeap.addAll(servers.indices)

        // end time, idx
        val executionHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        val rst = IntArray(tasks.size)

        var start = 0
        for ((i, t) in tasks.withIndex()) {
            start = maxOf(start, i)
            if (serverHeap.isEmpty())
                start = executionHeap.peek().first

            while (executionHeap.isNotEmpty() && executionHeap.peek().first <= start)
                serverHeap.add(executionHeap.poll().second)

            val idx = serverHeap.poll()
            executionHeap.add(start + t to idx)
            rst[i] = idx
        }

        return rst
    }
}