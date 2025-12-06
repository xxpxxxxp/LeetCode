package com.ypwang.medium

class Solution3765 {
    private fun isPrime(n: Int): Boolean {
        var i = 2
        while (i <= Math.sqrt(n.toDouble())) {
            if (n % i == 0)
                return false
            i++
        }
        return true
    }

    fun completePrime(num: Int): Boolean {
        var y = 0
        var z = 1
        var x = num
        while (x > 0) {
            y += z * (x % 10)
            if (y == 1 || !isPrime(y))
                return false
            if (x == 1 || !isPrime(x))
                return false
            x /= 10
            z *= 10
        }
        return true
    }
}
