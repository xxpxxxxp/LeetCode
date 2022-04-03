package com.ypwang.easy

class Solution2224 {
    fun convertTime(current: String, correct: String): Int {
        val (cu1, cu2) = current.split(":").map { it.toInt() }
        val (co1, co2) = correct.split(":").map { it.toInt() }

        var diff = ((co1 - cu1) * 60 + co2 - cu2 + 1440) % 1440
        var rst = 0
        for (i in listOf(60, 15, 5, 1)) {
            rst += diff / i
            diff %= i
        }
        return rst
    }
}