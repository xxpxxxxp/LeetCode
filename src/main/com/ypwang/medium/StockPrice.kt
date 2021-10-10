package com.ypwang.medium

import java.util.*

class StockPrice {
    private val prices = HashMap<Int, Int>()
    private val ordered = TreeMap<Int, Int>()
    private var latestTime = -1

    fun update(timestamp: Int, price: Int) {
        if (timestamp in prices) {
            val prevPrice = prices[timestamp]!!
            ordered[prevPrice] = ordered[prevPrice]!! - 1
            if (ordered[prevPrice] == 0)
                ordered.remove(prevPrice)
        }

        prices[timestamp] = price
        ordered[price] = ordered.getOrDefault(price, 0) + 1
        latestTime = maxOf(latestTime, timestamp)
    }

    fun current(): Int = prices[latestTime]!!
    fun maximum(): Int = ordered.lastKey()!!
    fun minimum(): Int = ordered.firstKey()!!
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * var obj = StockPrice()
 * obj.update(timestamp,price)
 * var param_2 = obj.current()
 * var param_3 = obj.maximum()
 * var param_4 = obj.minimum()
 */