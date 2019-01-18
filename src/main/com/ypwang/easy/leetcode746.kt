package com.ypwang.easy

class Solution746 {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val totalCost = MutableList(cost.size){0}
        totalCost[0] = cost[0]
        totalCost[1] = cost[1]
        for (i in 2 until cost.size) {
            totalCost[i] = kotlin.math.min(totalCost[i-1], totalCost[i-2]) + cost[i]
        }
        return kotlin.math.min(totalCost[cost.lastIndex], totalCost[cost.lastIndex-1])
    }
}