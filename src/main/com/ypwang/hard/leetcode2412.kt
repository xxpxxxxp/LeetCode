package com.ypwang.hard

class Solution2412 {
    fun minimumMoney(transactions: Array<IntArray>): Long {
        var res = 0L
        var v = 0
        for ((c, b) in transactions) {
            v = maxOf(v, minOf(c, b))
            res += maxOf(c - b, 0)
        }
        return res + v
    }
}