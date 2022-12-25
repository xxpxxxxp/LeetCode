package com.ypwang.medium

class Solution2512 {
    fun topStudents(positive_feedback: Array<String>, negative_feedback: Array<String>, report: Array<String>, student_id: IntArray, k: Int): List<Int> {
        val pf = positive_feedback.toSet()
        val nf = negative_feedback.toSet()

        return student_id.zip(report).map { it.first to it.second.split(' ').map { w ->
            when (w) {
                in pf -> 3
                in nf -> -1
                else -> 0
            }
        }.sum() }.sortedWith(compareByDescending<Pair<Int, Int>> { it.second }.thenBy { it.first }).take(k).map { it.first }
    }
}