package com.ypwang.easy

class Solution1018 {
    fun prefixesDivBy5(A: IntArray): BooleanArray {
        var mod = A[0]
        val rst = BooleanArray(A.size){A[0] == 0}
        for (i in 1 until A.size) {
            mod = (mod * 2 + A[i]) % 5
            rst[i] = mod == 0
        }

        return rst
    }
}

fun main() {
    println(Solution1018().prefixesDivBy5(intArrayOf(1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,0,0,1,0)).toList())
}