package com.ypwang.easy

class Solution3345 {
    fun productOfDigits(n: Int): Int {
        var product = 1
        var number = n
        while (number > 0) {
            product *= number % 10
            number /= 10
        }
        return product
    }

    fun smallestNumber(n: Int, t: Int): Int =
        (n..n+10).first { productOfDigits(it) % t == 0 }
}
