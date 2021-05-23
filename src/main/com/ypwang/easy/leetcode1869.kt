package com.ypwang.easy

class Solution1869 {
    fun checkZeroOnes(s: String): Boolean {
        val max = intArrayOf(0, 0)

        var cur = '1'
        var count = 0

        for (c in s) {
            if (cur != c) {
                max[cur - '0'] = maxOf(max[cur - '0'], count)
                cur = c
                count = 0
            }

            count++
        }

        max[cur - '0'] = maxOf(max[cur - '0'], count)

        return max[0] < max[1]
    }
}

fun main() {
    println("1101")
}