package com.ypwang.medium

class Solution1513 {
    fun numSub(s: String): Int {
        val mod = 1000000007

        var count = 0
        var rst = 0
        for (c in s) {
            when (c) {
                '0' -> {
                    rst = ((rst + count.toLong() * (count + 1) / 2) % mod).toInt()
                    count = 0
                }
                '1' -> count++
            }
        }

        return ((rst + count.toLong() * (count + 1) / 2) % mod).toInt()
    }
}