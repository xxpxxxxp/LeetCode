package com.ypwang.medium

class Solution932 {
    fun beautifulArray(N: Int): IntArray {
        if (N == 1) {
            return intArrayOf(1)
        }

        val rst = mutableListOf<Int>()
        rst.addAll(beautifulArray(N / 2).map { it * 2 })
        rst.addAll(beautifulArray(N - N / 2).map { it * 2 - 1 })
        return rst.toIntArray()
    }
}

fun main(args: Array<String>) {
    println(Solution932().beautifulArray(4).toList())
}