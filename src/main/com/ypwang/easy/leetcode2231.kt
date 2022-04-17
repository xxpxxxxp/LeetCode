package com.ypwang.easy

class Solution2231 {
    fun largestInteger(num: Int): Int {
        val str = num.toString().map { it - '0' }
        val odds = str.filter { it % 2 == 1 }.sortedDescending()
        val evens = str.filter { it % 2 == 0 }.sortedDescending()
        val rst = IntArray(str.size)
        var i = 0
        var j = 0
        for (z in rst.indices)
            rst[z] = if (str[z] % 2 == 0) evens[j++] else odds[i++]

        return rst.joinToString("").toInt()
    }
}

fun main() {
    println(Solution2231().largestInteger(1234))
}