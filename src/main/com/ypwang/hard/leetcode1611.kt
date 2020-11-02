package com.ypwang.hard

class Solution1661 {
    fun minimumOneBitOperations(n: Int): Int {
        var t = n
        var sign = 1
        var res = 0
        while (t > 0) {
            res += t xor (t - 1) * sign
            t = t and (t - 1)
            sign = -sign
        }
        return Math.abs(res)
    }
}

fun main() {
    println(Solution1661().minimumOneBitOperations(0))
    println(Solution1661().minimumOneBitOperations(3))
    println(Solution1661().minimumOneBitOperations(6))
    println(Solution1661().minimumOneBitOperations(9))
    println(Solution1661().minimumOneBitOperations(333))
}