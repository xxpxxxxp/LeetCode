package com.ypwang.medium

class Solution2545 {
    fun sortTheStudents(score: Array<IntArray>, k: Int): Array<IntArray> {
        score.sortByDescending { it[k] }
        return score
    }
}