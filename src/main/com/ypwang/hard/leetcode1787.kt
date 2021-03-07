package com.ypwang.hard

class Solution1787 {
    fun minChanges(nums: IntArray, k: Int): Int {
        val freq = Array(k){ IntArray(1025) }
        for ((i, v) in nums.withIndex())
            freq[i%k][v]++

        val dp = Array(k+1){ IntArray(1025) { 1000000000 } }
        dp[0][0] = 0
        var prevMin = 0

        for (i in 0 until k) {
            for (j in 0 until 1025) {
                for (z in i until nums.size step k) {
                    val v = j xor nums[z]
                    if (v < 1025) {
                        dp[i+1][v] = minOf(dp[i+1][v] , dp[i][j] + Math.ceil((nums.size-i)*1.0/k).toInt() - freq[i][nums[z]])
                    }
                }
            }

            var prevMin2 = 1000000000
            for(j in 0 until 1025){
                dp[i+1][j] = minOf(dp[i+1][j] , Math.ceil((nums.size-i)*1.0/k).toInt() + prevMin)
                prevMin2 = minOf(prevMin2, dp[i+1][j])
            }

            prevMin = prevMin2
        }

        return dp[k][0]
    }
}

fun main() {
    println(Solution1787().minChanges(intArrayOf(1,2,0,3,0), 1))
}