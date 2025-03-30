package com.ypwang.medium

class Solution3499 {
    fun maxActiveSectionsAfterTrade(s: String): Int {
        val t = "1${s}1"
        val n = t.length
        var i = 0
        var one = 0
        var zero = 0
        var curr = 0
        var prev = 0

        while (i < n && t[i] == '1') {
            one++
            i++
        }
        while (i < n && t[i] == '0') {
            prev++
            i++
        }

        while (i < n) {
            while (i < n && t[i] == '1') {
                one++
                i++
            }
            if (i == n)
                break
            while (i < n && t[i] == '0') {
                curr++
                i++
            }
            zero = maxOf(zero, prev + curr)
            prev = curr
            curr = 0
        }

        return one + zero - 2
    }
}
