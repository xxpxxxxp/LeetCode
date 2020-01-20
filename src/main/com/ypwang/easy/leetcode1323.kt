package com.ypwang.easy

class Solution1323 {
    fun maximum69Number (num: Int): Int {
        var p = 0
        var t = 1
        var rst = num
        while (t < rst) {
            if (num % (t*10) / t == 6) {
                rst += 3 * (t - p)
                p = t
            }
            t *= 10
        }

        return rst
    }
}

fun main() {
    println(Solution1323().maximum69Number(9669))
    println(Solution1323().maximum69Number(9996))
    println(Solution1323().maximum69Number(9999))
}