package com.ypwang.easy

class Solution2335 {
    fun fillCups(amount: IntArray): Int =
        maxOf(amount.maxOrNull()!!, (amount.sum() + 1) / 2)
}