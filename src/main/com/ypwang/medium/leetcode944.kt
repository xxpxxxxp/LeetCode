package com.ypwang.medium

class Solution944 {
    fun minDeletionSize(A: Array<String>): Int {
        return (0 until A[0].length).count { index ->
            val cur = A.map { it[index] }
            (0 until cur.lastIndex).any { i -> cur[i] > cur[i+1] }
        }
    }
}