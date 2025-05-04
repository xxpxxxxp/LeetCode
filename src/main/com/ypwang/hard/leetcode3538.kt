package com.ypwang.hard

class Solution3538 {
    fun minTravelTime(l: Int, n: Int, k: Int, position: IntArray, time: IntArray): Int {
        val prefix = LongArray(n)
        prefix[0] = time[0].toLong()
        for (idx in 1..<n - 1)
            prefix[idx] = prefix[idx - 1] + time[idx]
        prefix[n - 1] = prefix[n - 2]

        val steps = n - k
        val dp =
            Array(steps + 1) { Array(n) { LongArray(n + 1) { 10000000L } } }
        return solve(1, 0, 0, steps, position, prefix, dp).toInt()
    }

    private fun solve(
        k: Int,
        i: Int,
        last: Int,
        steps: Int,
        positions: IntArray,
        prefix: LongArray,
        dp: Array<Array<LongArray>>
    ): Long {
        if (dp[k][i][last] != 10000000L)
            return dp[k][i][last]

        if (k == steps)
            return if (i == positions.size - 1) 0L else 10000000L

        val rate = prefix[i] - (if (last > 0) prefix[last - 1] else 0)
        return ((i + 1 until positions.size).minOfOrNull {
            (positions[it] - positions[i]) * rate + solve(k + 1, it, i + 1, steps, positions, prefix, dp)
        } ?: 10000001L).also { dp[k][i][last] = it }
    }
}

fun main() {
    println(Solution3538().minTravelTime(10, 4, 1, intArrayOf(0, 3, 8, 10), intArrayOf(5,8,3,6)))
}