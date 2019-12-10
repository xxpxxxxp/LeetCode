package com.ypwang.hard

class Solution600 {
    fun findIntegers(num: Int): Int {
        val f = IntArray(32)
        f[0] = 1
        f[1] = 2
        for (i in 2 until 32) f[i] = f[i-1] + f[i-2]

        var sum = 0
        val len = num.toString(2).length
        var idx = len - 1
        while (idx >= 0) {
            if (num and (1 shl idx) != 0) {
                sum += f[idx]

                if (idx < 32 && num and (1 shl idx+1) != 0) {
                    sum--
                    break
                }
            }

            idx--
        }
        return sum + 1
    }
}

fun main() {
    println(Solution600().findIntegers(84))
}