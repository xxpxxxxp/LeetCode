package com.ypwang.medium

class Solution3592 {
    fun findCoins(numWays: IntArray): List<Int> {
        val n = numWays.size
        val ways = LongArray(n + 1)
        ways[0] = 1
        val coins = mutableListOf<Int>()

        for (a in 1..n) {
            val want = numWays[a - 1].toLong()
            val have = ways[a]
            val diff = want - have

            if (have > want)
                return emptyList()
            if (have == want)
                continue
            if (diff != 1L)
                return emptyList()

            coins.add(a)
            for (j in a..n)
                ways[j] += ways[j - a]
        }

        return coins
    }
}
