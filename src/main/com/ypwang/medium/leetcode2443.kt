package com.ypwang.medium

class Solution2443 {
    private fun reverse(n: Int): Int {
        var n = n
        var rst = 0
        while (n > 0) {
            rst = rst * 10 + n % 10
            n /= 10
        }
        return rst
    }

    fun sumOfNumberAndReverse(num: Int): Boolean {
        return (num/2..num).any { it + reverse(it) == num }
    }
}