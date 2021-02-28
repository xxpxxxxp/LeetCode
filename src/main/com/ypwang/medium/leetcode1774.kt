package com.ypwang.medium

class Solution1774 {
    fun closestCost(baseCosts: IntArray, toppingCosts: IntArray, target: Int): Int {
        fun dfs(subTotal: Int, topIdx: Int): Int {
            if (topIdx == toppingCosts.size)
                return subTotal

            // take none
            val none = dfs(subTotal, topIdx+1)
            val noneDiff = Math.abs(none - target)
            // take 1
            val take1 = dfs(subTotal + toppingCosts[topIdx], topIdx+1)
            val take1Diff = Math.abs(take1 - target)
            // take 2
            val take2 = dfs(subTotal + 2 * toppingCosts[topIdx], topIdx+1)
            val take2Diff = Math.abs(take2 - target)

            val take = if (take1Diff == take2Diff)
                minOf(take1, take2)
            else if (take1Diff < take2Diff)
                take1
            else
                take2

            val takeDiff = Math.abs(take - target)
            return if (takeDiff == noneDiff)
                minOf(take, none)
            else if (takeDiff < noneDiff)
                take
            else
                none
        }

        return baseCosts.map { dfs(it, 0) }
            .map { Math.abs(it - target) to it }
            .groupBy { it.first }
            .minBy { it.key }!!
            .value
            .minBy { it.second }!!
            .second
    }
}