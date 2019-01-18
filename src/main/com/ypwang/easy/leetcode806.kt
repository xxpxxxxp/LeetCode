package com.ypwang.easy

class Solution806 {
    fun numberOfLines(widths: IntArray, S: String): IntArray {
        val m = ('a'..'z').zip(widths.toList()).toMap()
        var totalline = if (S.isEmpty()) 0 else 1
        var lastline = 0
        S.forEach {
            lastline += m[it]!!
            if (lastline > 100) {
                totalline++
                lastline = m[it]!!
            }
        }
        return intArrayOf(totalline, lastline)
    }
}

fun main(args: Array<String>) {
    println(Solution806().numberOfLines(intArrayOf(10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10), "abcdefghijklmnopqrstuvwxyz"))
}