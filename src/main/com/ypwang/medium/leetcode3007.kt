package com.ypwang.medium

class Solution3007 {
    fun findMaximumNumber(k: Long, x: Int): Long {
        fun price(n: Long): Long {
            var rst = 0L
            for (i in x-1 until 63 step x) {
                if (n < 1L shl i)
                    break
                val c = n % (1L shl (i+1))
                rst += (n - c) / 2 + maxOf(c - (1L shl i), 0)
            }
            return rst
        }

        var l = 1L
        var r = 1e15.toLong()
        while (l < r) {
            val mid = (l + r + 1) / 2
            if (price(mid) <= k)
                l = mid
            else
                r = mid - 1
        }
        return l-1
    }
}

fun main() {
    println(Solution3007().findMaximumNumber(7L, 2))
}