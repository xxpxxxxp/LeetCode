package com.ypwang.easy

class Solution2432 {
    fun hardestWorker(n: Int, logs: Array<IntArray>): Int {
        logs.sortedBy { it[1] }
        for (i in logs.lastIndex downTo 1)
            logs[i][1] = logs[i][1] - logs[i-1][1]

        return logs.sortedWith(compareByDescending<IntArray> { it[1] }.thenBy { it[0] }).first()[0]
    }
}