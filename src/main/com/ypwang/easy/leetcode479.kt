package com.ypwang.easy

class Solution479 {
    fun largestPalindrome(n: Int): Int {
        if (n == 1) {
            return 9
        }

        val max = Math.pow(10.0, n.toDouble()).toInt() - 1
        for (v in max-1 downTo max/10+1) {
            val vs = v.toString()
            val u = (vs + vs.reversed()).toLong()
            var x = max.toLong()
            while (x * x >= u) {
                if (u % x == 0L) {
                    return (u %1337).toInt()
                }
                x--
            }
        }
        return 0
    }
}