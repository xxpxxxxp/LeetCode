package com.ypwang.medium

class Solution3723 {
    fun maxSumOfSquares(num: Int, sum: Int): String {
        if (sum > num * 9)
            return ""

        val rst = StringBuilder()
        var s = sum
        for (i in 0 until num) {
            val v = minOf(9, s)
            rst.append('0' + v)
            s -= v
        }

        return rst.toString()
    }
}
