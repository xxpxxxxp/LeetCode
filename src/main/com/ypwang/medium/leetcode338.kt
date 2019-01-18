package com.ypwang.medium

import java.lang.StringBuilder

class Solution338 {
    fun countBits(num: Int): IntArray {
        val rst = IntArray(num + 1){0}

        var b = 0
        for (i in 1..num) {
            if (i and (i-1) == 0) {
                rst[i] = 1
                b = i
            } else {
                rst[i] = rst[b] + rst[i - b]
            }
        }

        return rst
    }
}

fun main(args: Array<String>) {
    println(Solution338().countBits(5).toList())
}