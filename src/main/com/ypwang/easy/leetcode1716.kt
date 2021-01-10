package com.ypwang.easy

class Solution1716 {
    fun totalMoney(n: Int): Int {
        val div = n / 7
        val mod = n % 7

        return (mod + 1) * mod / 2 + mod * div + 28 * div + 7 * (div - 1) * div / 2
    }
}

fun main() {
    println(Solution1716().totalMoney(20))
    println(Solution1716().totalMoney(4))
    println(Solution1716().totalMoney(10))
}