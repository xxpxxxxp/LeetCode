package com.ypwang.medium

class Solution775 {
    fun isIdealPermutation(A: IntArray): Boolean = A.withIndex().all { Math.abs(it.index - it.value) <= 1 }
}