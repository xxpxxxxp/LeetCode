package com.ypwang.easy

class Solution2485 {
    fun pivotInteger(n: Int): Int {
        val sum = (1..n).sum()
        var cur = 0
        for (x in 1..n) {
            val d = sum - cur
            cur += x
            if (d == cur)
                return x
        }

        return -1
    }
}