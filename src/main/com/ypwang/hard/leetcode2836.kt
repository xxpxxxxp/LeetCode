package com.ypwang.hard

class Solution2836 {
    fun getMaxFunctionValue(receiver: List<Int>, k: Long): Long {
        val n = receiver.size

        val parent = Array(n) { IntArray(35) }
        val pathSum = Array(n) { LongArray(35) }

        for (i in 0 until n) {
            parent[i][0] = receiver[i]
            pathSum[i][0] = receiver[i].toLong()
        }

        for (p in 1 until 35) {
            for (i in 0 until n) {
                parent[i][p] = parent[parent[i][p-1]][p-1]
                pathSum[i][p] = pathSum[i][p-1] + pathSum[parent[i][p-1]][p-1]
            }
        }

        var rst = 0L
        for (s in 0 until n) {
            var i = s
            var sum = s.toLong()
            for (p in 0 until 35) {
                if (k and (1L shl p) > 0) {
                    sum += pathSum[i][p]
                    i = parent[i][p]
                }
            }

            rst = maxOf(sum, rst)
        }

        return rst
    }
}