package com.ypwang.easy

class Solution2037 {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int =
        seats.sorted().zip(students.sorted())
            .map { Math.abs(it.first - it.second) }
            .sum()
}