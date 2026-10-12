package com.ypwang.easy

class Solution4078 {
    fun threeFibonacciSum(n: Int): Boolean {
        var a = 0
        var b = 1
        var c = 1
        while (c < n) {
            if (a + b + c == n)
                return true

            a = b
            b = c
            c = a + b
        }
        return a + b + c == n
    }
}
