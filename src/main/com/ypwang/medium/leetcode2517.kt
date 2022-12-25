package com.ypwang.medium

class Solution2517 {
    fun maximumTastiness(price: IntArray, k: Int): Int {
        price.sort()
        var l = 0
        var r = price.last() - price.first()
        while (l < r) {
            val m = (l + r + 1) / 2
            var cnt = 1
            var i = 0
            for (j in 1 until price.size) {
                if (price[j] - price[i] >= m) {
                    cnt++
                    i = j
                }
            }
            if (cnt >= k)
                l = m
            else
                r = m-1
        }

        return l
    }
}