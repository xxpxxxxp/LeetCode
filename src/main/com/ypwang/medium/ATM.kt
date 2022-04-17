package com.ypwang.medium

class ATM {
    private val backnotes = longArrayOf(20L, 50L, 100L, 200L, 500L)
    private val remaining = LongArray(5)

    fun deposit(banknotesCount: IntArray) {
        for ((i, v) in banknotesCount.withIndex())
            remaining[i] += v.toLong()
    }

    fun withdraw(amount: Int): IntArray {
        var amount = amount
        val rst = IntArray(5)
        for ((i, b) in backnotes.withIndex().reversed()) {
            rst[i] = minOf(remaining[i], amount / b).toInt()
            amount -= (rst[i] * b).toInt()
            remaining[i] -= rst[i].toLong()
        }

        return if (amount > 0) {
            deposit(rst)
            intArrayOf(-1)
        } else rst
    }
}
