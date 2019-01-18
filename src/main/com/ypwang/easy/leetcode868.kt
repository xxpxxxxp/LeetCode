package com.ypwang.easy

class Solution868 {
    fun binaryGap(N: Int): Int {
        val s = N.toString(2)
        var p = s.indexOfFirst { it == '1' }
        if (p == -1 || p == (s.length-1)) {
            return 0
        }
        var max = 0
        for (f in (p+1) until  s.length) {
            if (s[f] == '1') {
                max = kotlin.math.max(max, f-p)
                p = f
            }
        }
        return max
    }
}

fun main(args: Array<String>) {
    println(Solution868().binaryGap(8))
}