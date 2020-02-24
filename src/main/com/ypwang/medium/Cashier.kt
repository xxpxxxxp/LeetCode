package com.ypwang.medium

class Cashier(val n: Int, val discount: Int, products: IntArray, prices: IntArray) {
    val map = products.zip(prices).map { it.first to it.second }.toMap()
    var count = 0

    fun getBill(product: IntArray, amount: IntArray): Double {
        val total = product.zip(amount).map { map[it.first]!! * it.second }.sum()
        if (++count == n) {
            count = 0
            return total * (1 - discount / 100.0)
        }
        return total.toDouble()
    }
}