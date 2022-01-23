package com.ypwang.easy

class Solution2144 {
    fun minimumCost(cost: IntArray): Int {
        cost.sortDescending()
        var rst = 0
        var i = 0
        while (3 * i < cost.size) {
            rst += cost[3 * i]
            if (3 * i + 1 < cost.size)
                rst += cost[3 * i + 1]

            i++
        }

        return rst
    }
}