package com.ypwang.hard

class Solution1449 {
    fun largestNumber(cost: IntArray, target: Int): String {
        val dp = Array<String?>(target + 1){ null }
        dp[0] = ""

        val comparator = Comparator { a: String, b: String ->
            if (a.length != b.length) a.length - b.length
            else a.zip(b).firstOrNull{ it.first != it.second }?.let { it.first - it.second } ?: 0
        }

        for (i in 1..target) {
            for ((j, v) in cost.withIndex()) {
                if (i - v >= 0 && dp[i-v] != null) {
                    val t = "${j+1}${dp[i-v]}"
                    dp[i] = dp[i]?.let { maxOf(it, t, comparator) } ?: t
                }
            }
        }

        return dp.last() ?: "0"
    }
}

fun main() {
    println(Solution1449().largestNumber(intArrayOf(4,3,2,5,6,7,2,5,5), 9))
    println(Solution1449().largestNumber(intArrayOf(7,6,5,5,5,6,8,7,8), 12))
    println(Solution1449().largestNumber(intArrayOf(2,4,6,2,4,6,4,4,4), 5))
    println(Solution1449().largestNumber(intArrayOf(6,10,15,40,40,40,40,40,40), 47))
}