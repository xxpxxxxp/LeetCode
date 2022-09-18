package com.ypwang.easy

class Solution2413 {
    fun smallestEvenMultiple(n: Int): Int =
        if (n % 2 == 0) n else 2*n
}