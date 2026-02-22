package com.ypwang.medium

class Solution3848 {
    fun isDigitorialPermutation(n: Int): Boolean {
        val factorial = intArrayOf(1,1,2,6,24,120,720,5040,40320,362880)
        val sum = n.toString().map { it - '0' }.map { factorial[it] }.sum()

        return sum.toString().length == n.toString().length && sum.toString().toCharArray().sorted() == n.toString().toCharArray().sorted()
    }
}
