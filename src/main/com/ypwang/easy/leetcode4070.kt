package com.ypwang.easy

class Solution4070 {
    fun minRotations(s: String): Int =
        s.fold('0' to 0) { (cur, sum), c ->
            c to (sum + minOf(Math.abs(cur - c), 10 - Math.abs(cur - c)))
        }.second
}
