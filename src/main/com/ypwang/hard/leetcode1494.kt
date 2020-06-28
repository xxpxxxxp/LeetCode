package com.ypwang.hard

class Solution1494 {
    fun minNumberOfSemesters(n: Int, dependencies: Array<IntArray>, k: Int): Int {
        val deps = IntArray(n)
        for ((a, b) in dependencies) {
            deps[b-1] = deps[b-1] or (1 shl a-1)
        }

        val dp = IntArray(1 shl n){ 100 }
        dp[0] = 0

        for (i in dp.indices) {
            var ex = 0
            for (j in 0 until n)
                if (i and deps[j] == deps[j])
                    ex = ex or (1 shl j)

            ex = ex and i.inv()
            val mask = ex
            while (ex > 0) {
                if (Integer.bitCount(ex) <= k) {
                    val k = i or ex
                    dp[k] = minOf(dp[k], dp[i] + 1)
                }

                ex = (ex - 1) and mask
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution1494().minNumberOfSemesters(4, arrayOf(
           intArrayOf(2,1), intArrayOf(3,1), intArrayOf(1,4)
    ), 2))
}