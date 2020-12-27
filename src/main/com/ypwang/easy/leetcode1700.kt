package com.ypwang.easy

class Solution1700 {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val count = IntArray(2)
        for (s in students) {
            count[s]++
        }

        for (i in sandwiches.indices) {
            if (--count[sandwiches[i]] < 0)
                return sandwiches.size - i
        }

        return 0
    }
}