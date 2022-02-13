package com.ypwang.easy

class Solution2169 {
    private fun helper(n1: Int, n2: Int): Int {
        if (n1 == 0)
            return 0

        return n2 / n1 + helper(n2 % n1, n1)
    }

    fun countOperations(num1: Int, num2: Int): Int =
        helper(minOf(num1, num2), maxOf(num1, num2))
}