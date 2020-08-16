package com.ypwang.medium

class Solution1551 {
    fun minOperations(n: Int): Int = (0 until (n/2)).sumBy{ n - 2 * it - 1 }
}