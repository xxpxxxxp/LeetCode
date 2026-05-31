package com.ypwang.medium

class Solution3946 {
    fun maximumSaleItems(items: Array<IntArray>, budget: Int): Int {
        val n = items.size
        val gain = IntArray(n)

        for (i in 0 until n) {
            val f = items[i][0]

            for (j in 0 until n)
                if (i != j && items[j][0] % f == 0)
                    gain[i]++
        }

        var dp = IntArray(budget + 1)

        for (i in 0 until n) {
            val cost = items[i][1]
            val first = gain[i] + 1

            val newDp = dp.clone()
            for (b in 0..budget-cost)
                newDp[b + cost] = maxOf(newDp[b + cost], dp[b] + first)

            for (b in cost..budget)
                newDp[b] = maxOf(newDp[b], newDp[b - cost] + 1)

            dp = newDp
        }

        return dp.max()
    }
}
