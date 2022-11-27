package com.ypwang.easy

class Solution2481 {
    fun numberOfCuts(n: Int): Int =
        when {
            n == 1 -> 0
            n%2 == 0 -> n/2
            else -> n
        }
}