package com.ypwang.easy

class Solution2544 {
    fun alternateDigitSum(n: Int): Int {
        var idx = 0
        var sum = 0

        var n = n
        while (n != 0) {
            val c = n % 10
            if (idx % 2 == 0)
                sum += c
            else
                sum -= c
            n /= 10
            idx++
        }

        return if (idx % 2 == 1) sum else -sum
    }
}

fun main() {
    println(Solution2544().alternateDigitSum(25))
    println(Solution2544().alternateDigitSum(521))
    println(Solution2544().alternateDigitSum(111))
    println(Solution2544().alternateDigitSum(886996))
}