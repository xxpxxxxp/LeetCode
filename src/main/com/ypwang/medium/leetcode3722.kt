package com.ypwang.medium

class Solution3722 {
    fun lexSmallest(s: String): String {
        var rst = s
        for (i in 1 .. s.length)
            rst = minOf(rst, s.take(i).reversed() + s.drop(i), s.take(i) + s.drop(i).reversed())

        return rst
    }
}

fun main() {
    println(Solution3722().lexSmallest("abba"))
}