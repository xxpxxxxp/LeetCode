package com.ypwang.medium

class Solution2280 {
    fun minimumLines(stockPrices: Array<IntArray>): Int {
        if (stockPrices.size < 2)
            return 0

        stockPrices.sortBy { it[0] }
        var rst = 1
        for (i in 1 until stockPrices.lastIndex) {
            val (preX, preY) = stockPrices[i-1]
            val (curX, curY) = stockPrices[i]
            val (nextX, nextY) = stockPrices[i+1]
            if ((curX - preX) * (nextY - curY) != (nextX - curX) * (curY - preY))
                rst++
        }

        return rst
    }
}