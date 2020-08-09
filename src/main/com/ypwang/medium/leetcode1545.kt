package com.ypwang.medium

class Solution1545 {
    fun findKthBit(n: Int, k: Int): Char {
        if (n == 1) return '0'

        val len = Math.pow(2.0, (n-1).toDouble()).toInt() - 1
        if (k == len+1) return '1'
        return if (k <= len)
            findKthBit(n-1, k)
        else
            ('0' + (findKthBit(n-1, 2*len+2-k) - '0' + 1) % 2).toChar()
    }
}

fun main() {
    println(Solution1545().findKthBit(3,1))
    println(Solution1545().findKthBit(4,11))
    println(Solution1545().findKthBit(1,1))
    println(Solution1545().findKthBit(2,3))
}