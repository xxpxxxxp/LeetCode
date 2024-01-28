package com.ypwang.medium

class Solution3021 {
    fun flowerGame(n: Int, m: Int): Long {
        val nOdd = (n + 1) / 2
        val nEven = n / 2
        val mOdd = (m + 1) / 2
        val mEven = m / 2

        return nOdd.toLong() * mEven + nEven.toLong() * mOdd
    }
}