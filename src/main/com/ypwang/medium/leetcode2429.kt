package com.ypwang.medium

class Solution2429 {
    fun minimizeXor(num1: Int, num2: Int): Int {
        var cnt = Integer.bitCount(num2)
        var rst = 0

        //from highest
        for (i in 31 downTo 0) {
            if (cnt == 0 || rst == num1)
                break

            if (num1 and (1 shl i) > 0) {
                rst = rst or (1 shl i)
                cnt--
            }
        }

        //from lowest
        for (i in 0..31) {
            if (cnt == 0)
                break

            if (rst and (1 shl i) == 0) {
                rst = rst or (1 shl i)
                cnt--
            }
        }

        return rst
    }
}