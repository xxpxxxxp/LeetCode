package com.ypwang.hard

class Solution1547 {
    fun minCost(n: Int, cuts: IntArray): Int {
        cuts.sort()
        val dp = Array(102){ IntArray(102){ Int.MAX_VALUE } }

        fun cut(points: IntArray, start: Int, end: Int): Int {
            if (start+1 == end) return 0

            if (dp[start][end] == Int.MAX_VALUE) {
                for (k in start+1 until end) {
                    dp[start][end] = minOf(
                            dp[start][end],
                            cut(points, start, k) + cut(points, k, end) + points[end] - points[start]
                    )
                }
            }

            return dp[start][end]
        }

        return cut(IntArray(cuts.size+2).apply {
            this[0] = 0
            this[lastIndex] = n
            System.arraycopy(cuts, 0, this, 1, cuts.size)
        }, 0, cuts.size + 1)
    }
}

fun main() {
    println(Solution1547().minCost(7, intArrayOf(1,3,4,5)))
    println(Solution1547().minCost(9, intArrayOf(5,6,1,4,2)))
}