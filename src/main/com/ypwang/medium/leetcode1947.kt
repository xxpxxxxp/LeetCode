package com.ypwang.medium

class Solution1947 {
    fun maxCompatibilitySum(students: Array<IntArray>, mentors: Array<IntArray>): Int {
        val dp = IntArray(1 shl (mentors.size)) { -1 }

        fun helper(student: Int, mask: Int): Int {
            if (student == students.size)
                return 0

            if (dp[mask] == -1) {
                var max = Int.MIN_VALUE
                for (i in mentors.indices) {
                    if ((1 shl i) and mask == 0) {
                        val mentor = mentors[i]
                        val match = students[student].zip(mentor).count { it.first == it.second }
                        max = maxOf(max, match + helper(student + 1, (1 shl i) or mask))
                    }
                }

                dp[mask] = max
            }

            return dp[mask]
        }

        return helper(0, 0)
    }
}

fun main() {
    println(Solution1947().maxCompatibilitySum(arrayOf(
        intArrayOf(1,1,0),intArrayOf(1,0,1),intArrayOf(0,0,1)
    ), arrayOf(
        intArrayOf(1,0,0),intArrayOf(0,0,1),intArrayOf(1,1,0)
    )))
}