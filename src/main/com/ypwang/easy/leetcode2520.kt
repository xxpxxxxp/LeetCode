package com.ypwang.easy

class Solution2520 {
    fun countDigits(num: Int): Int {
        var n = num
        var c = 0
        while (n > 0) {
            val t = n % 10
            n /= 10
            if (num % t == 0)
                c++
        }

        return c
    }
}