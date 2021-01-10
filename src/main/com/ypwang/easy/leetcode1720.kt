package com.ypwang.easy

class Solution1720 {
    fun decode(encoded: IntArray, first: Int): IntArray {
        val rst = IntArray(encoded.size + 1)
        rst[0] = first
        for (i in 0 until encoded.size) {
            rst[i+1] = rst[i] xor encoded[i]
        }

        return rst
    }
}