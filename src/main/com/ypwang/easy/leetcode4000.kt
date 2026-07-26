package com.ypwang.easy

class Solution4000 {
    fun largestInteger(n: Int, s: Int): Int {
        var sum = s
        val rst = StringBuilder()
        for (i in 0 until n) {
            val c = minOf(9, sum)
            rst.append(c)
            sum -= c
        }

        if (sum > 0)
            return -1

        return rst.toString().toInt()
    }
}
