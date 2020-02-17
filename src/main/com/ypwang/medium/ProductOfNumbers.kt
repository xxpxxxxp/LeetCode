package com.ypwang.medium

class ProductOfNumbers {
    private val list = mutableListOf(1)

    fun add(num: Int) {
        if (num == 0) {
            list.clear()
            list.add(1)
        } else {
            list.add(num * list.last())
        }
    }

    fun getProduct(k: Int): Int {
        return if (k >= list.size) 0 else list.last() / list[list.size - k]
    }
}