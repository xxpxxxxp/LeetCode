package com.ypwang.hard

// don't assign people to hat
// assign hat to people
// because there's at most 10 people, while there's 40 hat
class Solution1434 {
    fun numberWays(hats: List<List<Int>>): Int {
        val n = hats.size
        val hatStates = IntArray(40) // hatStates[i] means people who can wear i_th hat
        for ((i, hs) in hats.withIndex()) {
            for (hat in hs) {
                hatStates[hat-1] = hatStates[hat-1] or (1 shl i)
            }
        }
        val dp = Array(40) { Array(1024) {-1} }
        return dfs(hatStates, n, 0, 0, dp)
    }

    fun dfs(hatStates: IntArray, n: Int, hat: Int, chosen: Int, dp: Array<Array<Int>>): Int {
        if (hat == 40) return if (Integer.bitCount(chosen) == n) 1 else 0
        if (dp[hat][chosen] == -1) {
            dp[hat][chosen] = dfs(hatStates, n, hat + 1, chosen, dp) % 1000000007
            for (p in 0 until n) {
                if (getBit(chosen, p) == 1) continue
                if (getBit(hatStates[hat], p) == 1)
                    dp[hat][chosen] = (dp[hat][chosen] + dfs(hatStates, n, hat + 1, chosen or (1 shl p), dp)) % 1000000007
            }
        }

        return dp[hat][chosen]
    }

    private fun getBit(x: Int, i: Int): Int {
        return x shr i and 1
    }
}

fun main() {
    println(Solution1434().numberWays(listOf(listOf(3,4), listOf(4,5), listOf(5))))
    println(Solution1434().numberWays(listOf(listOf(3,5,1), listOf(3,5))))
    println(Solution1434().numberWays(listOf(listOf(1,2,3,4), listOf(1,2,3,4), listOf(1,2,3,4), listOf(1,2,3,4))))
    println(Solution1434().numberWays(listOf(listOf(1,2,3), listOf(2,3,5,6), listOf(1,3,7,9), listOf(1,8,9), listOf(2,5,7))))
}