package com.ypwang.easy

class Solution2160 {
    fun minimumSum(num: Int): Int {
        val n = intArrayOf(num / 1000, num % 1000 / 100, num % 100 / 10, num % 10)
        n.sort()
        return (n[0] + n[1]) * 10 + n[2] + n[3]
    }
}