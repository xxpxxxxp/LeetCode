package com.ypwang.medium

class Solution866 {
    fun primePalindrome(N: Int): Int {
        var n = N
        while (true) {
            if (n == reverse(n) && isPrime(n))
                return n
            n++
            if (n in 10000001..99999999)
                n = 100000000
        }
    }

    private fun isPrime(N: Int): Boolean =  if (N < 2) false else (2..Math.sqrt(N.toDouble()).toInt()).all { N % it!= 0 }

    private fun reverse(N: Int): Int {
        var n = N
        var ans = 0
        while (n > 0) {
            ans = 10 * ans + N % 10
            n /= 10
        }
        return ans
    }
}

fun main() {
    println(Solution866().primePalindrome(6))
}