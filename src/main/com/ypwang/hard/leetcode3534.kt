package com.ypwang.hard

class Solution3534 {
    fun pathExistenceQueries(n: Int, nums: IntArray, maxDiff: Int, queries: Array<IntArray>): IntArray {
        val A = nums.withIndex().sortedBy { it.value }
        val sorted = A.map { it.value }.toIntArray()

        val pos = IntArray(n)
        for (i in 0 until n)
            pos[A[i].index] = i

        val R =
            IntArray(n) { upperBound(sorted, sorted[it] + maxDiff) - 1 }

        var LOG = 1
        while ((1 shl LOG) <= n)
            LOG++
        val jump = Array(LOG) { IntArray(n) }
        jump[0] = R.copyOf()
        for (k in 1 until LOG)
            for (i in 0 until n)
                jump[k][i] = jump[k - 1][jump[k - 1][i]]

        // Process queries
        val ans = IntArray(queries.size)
        for ((i, q) in queries.withIndex()) {
            var u = pos[q[0]]
            var v = pos[q[1]]

            if (u == v) {
                ans[i] = 0
                continue
            }

            if (u > v) {
                val temp = u
                u = v
                v = temp
            }

            if (R[u] <= u) {
                ans[i] = -1
                continue
            }

            var hops = 0
            var cur = u
            for (k in LOG - 1 downTo 0) {
                val next = jump[k][cur]
                if (next < v) {
                    hops += (1 shl k)
                    cur = next
                }
            }

            ans[i] = if (R[cur] < v) -1 else hops + 1
        }
        return ans
    }

    private fun upperBound(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size
        while (left < right) {
            val mid = (left + right) / 2
            if (arr[mid] <= target)
                left = mid + 1
            else
                right = mid
        }
        return left
    }
}

fun main() {
    println(Solution3534().pathExistenceQueries(2, intArrayOf(0, 3), 2, arrayOf(intArrayOf(1,0))).toList())
    println(
        Solution3534().pathExistenceQueries(
            5, intArrayOf(1, 8, 3, 4, 2), 3, arrayOf(
                intArrayOf(0, 3), intArrayOf(2, 4)
            )
        ).toList()
    )
}