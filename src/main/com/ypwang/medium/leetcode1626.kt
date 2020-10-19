package com.ypwang.medium

class Solution1626 {
    fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
        // sorted by age asc, max score get at age
        val dp = mutableListOf<IntArray>()

        for ((s, a) in scores.zip(ages).sortedWith(compareBy<Pair<Int, Int>>{it.first}.thenBy{it.second})) {
            val idx = dp.binarySearch { it[0] - a }

            if (idx >= 0) {
                dp[idx][1] += s
                while (idx+1 < dp.size && dp[idx+1][1] <= dp[idx][1]) {
                    dp.removeAt(idx+1)
                }
            } else {
                val pidx = -idx-1
                val value = if (pidx > 0) dp[pidx-1][1] + s else s
                dp.add(pidx, intArrayOf(a, value))
                while (pidx+1 < dp.size && dp[pidx+1][1] <= value) {
                    dp.removeAt(pidx+1)
                }
            }
        }

        return dp.last()[1]
    }
}

fun main() {
    println(Solution1626().bestTeamScore(intArrayOf(1,1,1,1,1,1,1,1,1,1),
            intArrayOf(811,364,124,873,790,656,581,446,885,134)))
    println(Solution1626().bestTeamScore(intArrayOf(1,3,5,10,15), intArrayOf(1,2,3,4,5)))
    println(Solution1626().bestTeamScore(intArrayOf(4,5,6,5), intArrayOf(2,1,2,1)))
    println(Solution1626().bestTeamScore(intArrayOf(1,2,3,5), intArrayOf(8,9,10,1)))
}