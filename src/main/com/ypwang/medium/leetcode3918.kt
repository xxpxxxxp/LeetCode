package com.ypwang.medium

class Solution3918 {
    private fun isPrime(n: Int): Boolean {
        if (n <= 1)
            return false

        var i = 2
        while (i * i <= n) {
            if (n % i == 0)
                return false
            i++
        }

        return true
    }

    fun sumOfPrimesInRange(n: Int): Int {
        var n = n
        var rev = 0
        val num = n
        while (n > 0) {
            rev = (rev * 10) + (n % 10)
            n /= 10
        }

        var lt = minOf(rev, num)
        val rt = maxOf(rev, num)

        var sum = 0
        while (lt <= rt) {
            if (isPrime(lt))
                sum += lt

            lt++
        }

        return sum
    }
}
