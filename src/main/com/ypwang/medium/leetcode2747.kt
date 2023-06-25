package com.ypwang.medium

class Solution2747 {
    fun countServers(n: Int, logs: Array<IntArray>, x: Int, queries: IntArray): IntArray {
        logs.sortBy { it[1] }
        val rst = IntArray(queries.size)

        val count = IntArray(n+1)
        var used = 0
        var left = 0
        var right = 0

        for ((i, q) in queries.withIndex().sortedBy { it.value }) {
            while (right < logs.size && logs[right][1] <= q) {
                if (count[logs[right][0]] == 0)
                    used++
                count[logs[right][0]]++
                right++
            }

            while (left < logs.size && logs[left][1] < q - x) {
                count[logs[left][0]]--
                if (count[logs[left][0]] == 0)
                    used--
                left++
            }

            rst[i] = n - used
        }

        return rst
    }
}
