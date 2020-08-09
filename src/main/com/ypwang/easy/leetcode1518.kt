package com.ypwang.easy

class Solution1518 {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        var full = numBottles
        var drink = 0

        while (full >= numExchange) {
            val d = full / numExchange
            drink += d * numExchange
            full = d + full % numExchange
        }

        return drink + full
    }
}