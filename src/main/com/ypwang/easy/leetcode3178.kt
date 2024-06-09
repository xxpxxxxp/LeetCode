package com.ypwang.easy

class Solution3178 {
    fun numberOfChild(n: Int, k: Int): Int {
        val k = k % (2 * (n - 1))
        return if (k <= n-1) k else 2 * n - 2 - k
    }
}
