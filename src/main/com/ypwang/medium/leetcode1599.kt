package com.ypwang.medium

class Solution1599 {
    fun minOperationsMaxProfit(customers: IntArray, boardingCost: Int, runningCost: Int): Int {
        if (boardingCost * 4 <= runningCost) return -1

        var count = 0
        var money = 0
        var income = 0
        var rotate = -1

        for ((i, customer) in customers.withIndex()) {
            count += customer
            val take = minOf(4, count)
            count -= take
            income += boardingCost * take - runningCost
            if (income > money) {
                money = income
                rotate = i+1
            }
        }

        rotate += count / 4
        if ((count % 4) * boardingCost > runningCost)
            rotate++

        return rotate
    }
}

fun main() {
    println(Solution1599().minOperationsMaxProfit(intArrayOf(8,3), 5, 6))
}