package com.ypwang.easy

class Solution2303 {
    fun calculateTax(brackets: Array<IntArray>, income: Int): Double {
        var rst = 0.0
        var ground = 0
        for ((a, b) in brackets) {
            rst += (minOf(a, income) - ground) * b / 100.0
            if (a >= income)
                return rst
            ground = a
        }
        return rst
    }
}