package com.ypwang.easy

class Solution3658 {
    fun gcd(a: Int, b: Int): Int =
        if (a == 0) b else gcd(b % a, a)

    fun gcdOfOddEvenSums(n: Int): Int {
        val odd = n * n
        val even = odd + n

        return gcd(odd, even)
    }
}
