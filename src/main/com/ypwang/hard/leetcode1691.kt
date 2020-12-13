package com.ypwang.hard

class Solution1691 {
    fun maxHeight(cuboids: Array<IntArray>): Int {
        cuboids.forEach { it.sort() }
        cuboids.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] }.thenBy { it[2] })

        val dp = IntArray(cuboids.size){1}
        var rst = 0

        for ((i, t1) in cuboids.withIndex()) {
            dp[i] = t1[2]
            for (j in 0 until i) {
                val t2 = cuboids[j]
                if (t1[0] >= t2[0] && t1[1] >= t2[1] && t1[2] >= t2[2])
                    dp[i] = maxOf(dp[i], t1[2] + dp[j])
            }

            rst = maxOf(rst, dp[i])
        }

        return rst
    }
}