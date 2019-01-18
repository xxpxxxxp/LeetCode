package com.ypwang.easy

class Solution67 {
    fun addBinary(a: String, b: String): String {
        val rst = mutableListOf<Char>()
        var inc = 0
        for (i in 0 until Math.max(a.length, b.length)) {
            var sum = inc
            sum += if (i > a.lastIndex) 0 else a[a.lastIndex - i] - '0'
            sum += if (i > b.lastIndex) 0 else b[b.lastIndex - i] - '0'
            rst.add('0' + sum % 2)
            inc = sum / 2
        }
        if (inc > 0) {
            rst.add('0' + inc)
        }
        rst.reverse()
        return rst.joinToString("")
    }
}

fun main(args: Array<String>) {
    println(Solution67().addBinary("1", "11"))
}