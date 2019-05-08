package com.ypwang.easy

class Solution989 {
    fun addToArrayForm(A: IntArray, K: Int): List<Int> {
        var k = K
        val rst = mutableListOf<Int>()
        var inc = 0

        for (i in A.lastIndex downTo 0) {
            val sum = inc + A[i] + (k % 10)
            k /= 10
            rst.add(0, sum % 10)
            inc = sum / 10
        }

        while (k > 0) {
            val sum = inc + (k % 10)
            k /= 10
            rst.add(0, sum % 10)
            inc = sum / 10
        }

        if (inc > 0)
            rst.add(0, inc)

        return rst
    }
}