package com.ypwang.easy

class Solution1013 {
    fun canThreePartsEqualSum(A: IntArray): Boolean {
        val sum = A.sum()
        if (sum % 3 != 0) return false

        val target = sum / 3

        var i = 0
        for (t in 0..2) {
            var s = 0
            while (i < A.size && s != target) {
                s += A[i]
                i++
            }

            if (s != target) return false
        }
        return true
    }
}