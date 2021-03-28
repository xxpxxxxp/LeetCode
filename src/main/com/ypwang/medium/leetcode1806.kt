package com.ypwang.medium

class Solution1806 {
    fun reinitializePermutation(n: Int): Int {
        if (n == 2)
            return 1

        val mod = n - 1
        var count = 1
        var cur = 2
        while (cur != 1) {
            cur = cur * 2 % mod
            count++
        }

        return count
    }
}