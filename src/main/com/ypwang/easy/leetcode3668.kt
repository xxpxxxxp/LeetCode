package com.ypwang.easy

class Solution3668 {
    fun recoverOrder(order: IntArray, friends: IntArray): IntArray {
        val f = friends.toSet()
        return order.filter { it in f }.toIntArray()
    }
}
