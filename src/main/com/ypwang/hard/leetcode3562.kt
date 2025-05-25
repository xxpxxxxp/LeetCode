package com.ypwang.hard

class Solution3562 {
    fun maxProfit(n: Int, present: IntArray, future: IntArray, hierarchy: Array<IntArray>, budget: Int): Int {
        val tree = Array(n) { mutableListOf<Int>() }
        for ((a, b) in hierarchy)
            tree[a - 1].add(b - 1)

        val dp = Array(n) { Array(2) { IntArray(budget + 1) } }
        dfs(0, present, future, tree, dp, budget)

        return (0..budget).maxOf { dp[0][0][it] }
    }

    private fun dfs(u: Int, present: IntArray, future: IntArray,
                    tree: Array<MutableList<Int>>, dp: Array<Array<IntArray>>, budget: Int) {
        // Base case: no children, init to 0
        for (b in 0..budget) {
            dp[u][1][b] = 0
            dp[u][0][b] = dp[u][1][b]
        }

        // For each child, process recursively
        val childDPs = mutableListOf<Array<IntArray>>()
        for (v in tree[u]) {
            dfs(v, present, future, tree, dp, budget)
            childDPs.add(arrayOf(dp[v][0], dp[v][1]))
        }

        // For parentNotBought and parentBought
        for (parentBought in 0..1) {
            val price = if (parentBought == 1) present[u] / 2 else present[u]
            val profit = future[u] - price

            // Create DP array to fill for this u
            val curr = IntArray(budget + 1)

            // Option 1: don't buy u
            var base = IntArray(budget + 1)
            base[0] = 0
            for (child in childDPs) {
                val next = IntArray(budget + 1)
                for (b1 in 0..budget) {
                    var b2 = 0
                    while (b1 + b2 <= budget) {
                        next[b1 + b2] = maxOf(next[b1 + b2], base[b1] + child[0][b2])
                        b2++
                    }
                }
                base = next
            }

            for (b in 0..budget)
                curr[b] = maxOf(curr[b], base[b]) // not buying u

            // Option 2: buy u
            if (price <= budget) {
                var baseBuy = IntArray(budget + 1)
                baseBuy[0] = 0
                for (child in childDPs) {
                    val next = IntArray(budget + 1)
                    for (b1 in 0..budget) {
                        var b2 = 0
                        while (b1 + b2 <= budget) {
                            next[b1 + b2] = maxOf(next[b1 + b2], baseBuy[b1] + child[1]!![b2])
                            b2++
                        }
                    }
                    baseBuy = next
                }

                for (b in price..budget)
                    curr[b] = maxOf(curr[b], baseBuy[b - price] + profit)
            }

            dp[u][parentBought] = curr
        }
    }
}
