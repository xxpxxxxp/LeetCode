package com.ypwang.medium

class Solution264 {
    fun nthUglyNumber(n: Int): Int {
        var i = 0
        var j = 0
        var k = 0

        var count = 1
        val rst = ArrayList<Int>()
        rst.add(1)

        while (count < n) {
            val t = minOf(2 * rst[i], 3 * rst[j], 5 * rst[k])
            if (t == 2 * rst[i]) i++
            if (t == 3 * rst[j]) j++
            if (t == 5 * rst[k]) k++
            rst.add(t)
            count++
        }

        return rst.last()
    }
}

fun main() {
    println(Solution264().nthUglyNumber(10))
}