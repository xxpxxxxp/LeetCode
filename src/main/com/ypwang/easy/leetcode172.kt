package com.ypwang.easy

class Solution172 {
    fun trailingZeroes(n: Int): Int {
        var t = n / 10
        var rst = 0
        while (t / 10 > 0) {
            rst += t % 10
            t = t / 10
        }
        return rst
    }
}

fun main(args: Array<String>) {
    println(Solution172().trailingZeroes(123154))
}