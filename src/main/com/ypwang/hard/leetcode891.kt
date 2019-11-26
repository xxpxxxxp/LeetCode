package com.ypwang.hard

class Solution891 {
    private val mod = 1000000007
    fun sumSubseqWidths(A: IntArray): Int = A.sorted().toIntArray().let {
            ((it.withIndex().fold(0L to 1L){ (rst, c), (i, v) ->
                (rst + (v - it[it.size - i - 1]) * c) % mod to (c shl 1) % mod
            }.first + mod) % mod).toInt()
        }
}

fun main() {
    println(Solution891().sumSubseqWidths(intArrayOf(2,1,3)))
    println(Solution891().sumSubseqWidths(intArrayOf(5,69,89,92,31,16,25,45,63,40,16,56,24,40,75,82,40,12,50,62,92,44,67,38,92,22,91,24,26,21,100,42,23,56,64,43,95,76,84,79,89,4,16,94,16,77,92,9,30,13)))
}