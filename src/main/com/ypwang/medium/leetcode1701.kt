package com.ypwang.medium

class Solution1701 {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        var time = 0.0
        var wait = 0.0
        for ((a, b) in customers) {
            time = maxOf(time, a.toDouble()) + b
            wait += time - a
        }

        return wait / customers.size
    }
}