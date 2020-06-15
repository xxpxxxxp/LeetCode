package com.ypwang.easy

import java.util.*

class Solution1475 {
    fun finalPrices(prices: IntArray): IntArray {
        val stack = Stack<Int>().apply { this.add(0) }
        val rst = prices.copyOf()

        for (i in prices.indices.reversed()) {
            while (stack.peek() > prices[i])
                stack.pop()

            rst[i] -= stack.peek()
            stack.add(prices[i])
        }

        return rst
    }
}