package com.ypwang.easy

class Solution2591 {
    fun distMoney(money: Int, children: Int): Int {
        val m = money - children
        if (m < 0)
            return -1
        val d = m / 7
        val mod = m % 7
        if (d == children && mod == 0)
            return children
        if (d == children - 1 && mod == 3)
            return children - 2
        return minOf(children-1, d)
    }
}