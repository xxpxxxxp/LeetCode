package com.ypwang.medium

class Solution319 {
    fun bulbSwitch(n: Int): Int {
        var i = 1
        while (i * i <= n) {
            i++
        }
        return i - 1
    }
}