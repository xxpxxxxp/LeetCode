package com.ypwang.hard

class Solution1344 {
    fun maxJumps(arr: IntArray, d: Int): Int {
        val dp = IntArray(arr.size)

        fun dfs(i: Int): Int {
            if (dp[i] == 0) {
                var res = 1

                for (j in i+1..minOf(i+d, arr.lastIndex)) {
                    if (arr[j] >= arr[i]) break
                    res = maxOf(res, 1 + dfs(j))
                }

                for (j in i-1 downTo maxOf(i-d, 0)) {
                    if (arr[j] >= arr[i]) break
                    res = maxOf(res, 1 + dfs(j))
                }

                dp[i] = res
            }

            return dp[i]
        }

        return arr.indices.fold(1){ acc, it -> maxOf(acc, dfs(it)) }
    }
}

fun main() {
    println(Solution1344().maxJumps(intArrayOf(6,4,14,6,8,13,9,7,10,6,12), 2))
}