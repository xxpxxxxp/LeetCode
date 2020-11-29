package com.ypwang.medium

class Solution650 {
    fun minSteps(n: Int): Int {
        var ans = 0
        var d = 2
        var tmp = n
        while (tmp > 1) {
            while (tmp % d == 0) {
                ans += d
                tmp /= d
            }
            d++
        }
        return ans
    }
}

fun main() {
    println(Solution650().minSteps(3))
}