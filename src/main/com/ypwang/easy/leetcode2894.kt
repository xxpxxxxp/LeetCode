package com.ypwang.easy

class Solution2894 {
    fun differenceOfSums(n: Int, m: Int): Int {
        val d = n / m
        return (n + 1) * n / 2 - m * (d + 1) * d
    }
}