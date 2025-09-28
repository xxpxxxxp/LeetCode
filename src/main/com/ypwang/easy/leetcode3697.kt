package com.ypwang.easy

class Solution3697 {
    fun decimalRepresentation(n: Int): IntArray {
        val rst = mutableListOf<Int>()
        var t = 1
        var n = n

        while (n != 0) {
            val m = n % 10
            if (m != 0)
                rst.add(m * t)

            t *= 10
            n /= 10
        }

        return rst.reversed().toIntArray()
    }
}
