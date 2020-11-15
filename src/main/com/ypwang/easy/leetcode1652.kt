package com.ypwang.easy

class Solution1652 {
    fun decrypt(code: IntArray, k: Int): IntArray {
        if (k == 0) {
            code.fill(0)
            return code
        }

        val new = IntArray(code.size)
        val direction = k > 0
        val step = Math.abs(k)
        var sum = (0 until step).sumBy { code[it] }
        for (j in code.indices) {
            val idx =
                    if (direction) (j + code.size - 1) % code.size
                    else (j+step) % code.size

            new[idx] = sum
            sum += code[(j+step) % code.size]
            sum -= code[j]
        }

        return new
    }
}