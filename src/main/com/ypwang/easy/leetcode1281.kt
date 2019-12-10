package com.ypwang.easy

class Solution1281 {
    fun subtractProductAndSum(n: Int): Int {
        var p = 1
        var s = 0
        var nn = n

        while (nn > 0) {
            val t = nn % 10
            p *= t
            s += t
            nn /= 10
        }

        return p - s
    }
}