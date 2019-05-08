package com.ypwang.easy

class Solution1009 {
    fun bitwiseComplement(N: Int): Int {
        if (N == 0) return 1

        var count = 0
        var t = N
        while (t > 0) {
            count++
            t = t shr 1
        }

        return N.inv() and ((1 shl count) - 1)
    }
}

fun main() {
    println(Solution1009().bitwiseComplement(0))
}