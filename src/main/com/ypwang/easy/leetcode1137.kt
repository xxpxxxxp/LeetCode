package com.ypwang.easy

class Solution1137 {
    fun tribonacci(n: Int): Int {
        return when (n) {
            0 -> 0
            1 -> 1
            2 -> 1
            else -> {
                val r = IntArray(n+1)
                r[0] = 0
                r[1] = 1
                r[2] = 1
                for (i in 3..n) {
                    r[i] = r[i-3] + r[i-2] + r[i-1]
                }

                return r.last()
            }
        }
    }
}