package com.ypwang.medium

class Solution2483 {
    fun bestClosingTime(customers: String): Int {
        var penalty = customers.count { it == 'N' }
        var min = penalty
        var idx = customers.length

        for ((i, c) in customers.withIndex().reversed()) {
            when (c) {
                'Y' -> penalty++
                'N' -> penalty--
            }

            if (penalty <= min) {
                idx = i
                min = penalty
            }
        }

        return idx
    }
}

fun main() {
    println(Solution2483().bestClosingTime("YYNY"))
}