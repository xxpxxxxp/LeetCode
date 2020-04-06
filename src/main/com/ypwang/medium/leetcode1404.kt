package com.ypwang.medium

class Solution1404 {
    fun numSteps(s: String): Int {
        var rst = 0
        var carry = false
        for (c in s.drop(1).reversed()) {
            rst++
            if (!(carry xor (c == '0'))) {
                carry = true
                rst++
            }
        }

        if (carry) rst++
        return rst
    }
}

fun main() {
    println(Solution1404().numSteps("1101"))
    println(Solution1404().numSteps("10"))
    println(Solution1404().numSteps("1"))
}