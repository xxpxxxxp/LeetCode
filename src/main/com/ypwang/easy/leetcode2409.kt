package com.ypwang.easy

class Solution2409 {
    fun countDaysTogether(arriveAlice: String, leaveAlice: String, arriveBob: String, leaveBob: String): Int {
        val a = intArrayOf(getVal(arriveAlice), getVal(leaveAlice))
        val b = intArrayOf(getVal(arriveBob), getVal(leaveBob))
        if (b[0] > a[1] || a[0] > b[1])
            return 0 // no overlap
        val start = maxOf(a[0], b[0])
        val last = minOf(a[1], b[1])
        return last - start + 1
    }

    private val months = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    // convert date to nth day of year, (1st-365th day)
    private fun getVal(str: String): Int {
        var idx = 0
        val mon = (str[0] - '0') * 10 + (str[1] - '0')
        val day = (str[3] - '0') * 10 + (str[4] - '0')
        for (i in 1 until mon)
            idx += months[i - 1] // or use prefix sum
        return idx + day
    }
}