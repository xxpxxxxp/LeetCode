package com.ypwang.medium

import java.util.*

class Solution1376 {
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val managerMap = manager.withIndex()
                .map { it.value to it.index }
                .groupBy { it.first }
                .mapValues { it.value.map { kv -> kv.second } }
                .toMap()

        val bfs: Queue<Pair<Int, Int>> = LinkedList()
        bfs.add(managerMap[-1]!!.single() to 0)

        var rst = 0
        while (bfs.isNotEmpty()) {
            val (id, time) = bfs.poll()
            rst = maxOf(rst, time)
            if (id in managerMap)
                bfs.addAll(managerMap[id]!!.map { it to time + informTime[id] })
        }

        return rst
    }
}