package com.ypwang.medium

class Solution3457 {
    fun maxWeight(pizzas: IntArray): Long {
        pizzas.sort()
        val n = pizzas.size
        val days = n / 4
        var totalWeight = 0L
        var index = n - 1

        for (day in 1..days step 2)
            totalWeight += pizzas[index--]

        index--
        for (day in 2..days step 2) {
            totalWeight += pizzas[index]
            index -= 2
        }

        return totalWeight
    }
}
