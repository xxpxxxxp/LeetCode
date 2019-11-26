package com.ypwang.hard

class Solution829 {
    fun consecutiveNumbersSum(N: Int): Int {
        var n = N
        while (n and 1 == 0) n = n shr 1
        var ans = 0
        var d = 1

        while (d * d <= n) {
            if (n % d == 0) {
                ans += if (n == d * d) 1 else 2
            }
            d += 2
        }

        //if (n > 1) ans = ans shl 1
        return ans
    }
}

fun main() {
    println(Solution829().consecutiveNumbersSum(5))
    println(Solution829().consecutiveNumbersSum(9))
    println(Solution829().consecutiveNumbersSum(15))
}