package com.ypwang.hard

class Solution1478 {
    private val max = 1000000

    fun minDistance(houses: IntArray, k: Int): Int {
        houses.sort()
        val dp = Array(houses.size){ IntArray(k){-1} }

        fun solve(pos: Int, box: Int): Int {
            if (pos == houses.size)
                return if (box == k) 0 else max

            if (box == k) return max

            if (dp[pos][box] == -1) {
                var ans = max
                for (i in pos until houses.size) {
                    val median = houses[(i + pos) / 2]
                    var cost = 0
                    for (j in pos..i)
                        cost += Math.abs(median - houses[j])

                    ans = minOf(ans, cost + solve(i+1, box+1))
                }

                dp[pos][box] = ans
            }

            return dp[pos][box]
        }

        return solve(0, 0)
    }
}

fun main() {
    println(Solution1478().minDistance(intArrayOf(1,4,8,10,20), 3))
    println(Solution1478().minDistance(intArrayOf(2,3,5,12,18), 2))
    println(Solution1478().minDistance(intArrayOf(7,4,6,1), 1))
    println(Solution1478().minDistance(intArrayOf(3,6,14,10), 4))
}