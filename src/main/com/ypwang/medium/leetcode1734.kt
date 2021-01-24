package com.ypwang.medium

class Solution1734 {
    fun decode(encoded: IntArray): IntArray {
        val first = (1..(encoded.size+1)).reduce { acc, i -> acc xor i } xor
                (1 until encoded.size step 2).map { encoded[it] }.reduce { acc, i -> acc xor i }

        val rst = IntArray(encoded.size + 1)
        rst[0] = first
        for (i in 1 until rst.size) {
            rst[i] = rst[i-1] xor encoded[i-1]
        }

        return rst
    }
}