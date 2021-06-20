package com.ypwang.medium

class Solution1904 {
    private fun helper(time: String, roundUp: Boolean): Int {
        val (h, m) = time.split(':').map { it.toInt() }
        val inHour =
            if (roundUp)
                (m + 14) / 15
            else
                m / 15
        return h * 4 + inHour
    }

    fun numberOfRounds(startTime: String, finishTime: String): Int =
        (helper(finishTime, false) - helper(startTime, true)).let {
            if (it >= 0) it
            else it + 96
        }
}

fun main() {
    println(Solution1904().numberOfRounds("12:01", "12:44"))
    println(Solution1904().numberOfRounds("20:00", "06:00"))
    println(Solution1904().numberOfRounds("00:00", "23:59"))
}