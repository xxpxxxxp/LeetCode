package com.ypwang.medium

class Solution1318 {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        var rst = 0
        for (i in 0 until 32) {
            rst += when ((c shr i) and 0x1) {
                0 -> ((a shr i) and 0x1) + ((b shr i) and 0x1)
                1 -> if (((a shr i) and 0x1) + ((b shr i) and 0x1) > 0) 0 else 1
                else -> 0
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1318().minFlips(2, 6, 5))
}