package com.ypwang.medium

class Solution2861 {
    fun func(mid: Long, budget: Int, composition: List<List<Int>>, stock: List<Int>, cost: List<Int>): Boolean =
        composition.map { arr ->
            arr.indices.map { i ->
                val curr = mid * arr[i]
                if (stock[i] >= curr)
                    0
                else
                    (curr - stock[i]) * cost[i]
            }.sum()
        }.min() <= budget

    fun maxNumberOfAlloys(n: Int, k: Int, budget: Int, composition: List<List<Int>>, stock: List<Int>, cost: List<Int>): Int {
        var low = 0L
        var high = 1000000000L
        while (low < high) {
            val mid = (low + high + 1) / 2
            if (func(mid, budget, composition, stock, cost))
                low = mid
            else
                high = mid - 1
        }
        return low.toInt()
    }
}