package com.ypwang.easy

class Solution3622 {
    fun checkDivisibility(n: Int): Boolean {
        val t = n.toString().map { it - '0' }
        val sum = t.sum() + t.fold(1) { a, b -> a * b }
        return n % sum == 0
    }
}
