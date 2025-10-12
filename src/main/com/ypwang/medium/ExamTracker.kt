package com.ypwang.medium

class ExamTracker {
    var t = mutableListOf<Int>()
    var x = mutableListOf<Long>()

    fun record(time: Int, score: Int) {
        t.add(time)
        x.add(score + (if (x.isEmpty()) 0 else x[x.size - 1]))
    }

    private fun solve(t: MutableList<Int>, tar: Int): Int {
        var i = 0
        var j = t.size
        while (i < j) {
            val mid = (i + j) / 2
            if (t[mid] <= tar)
                i = mid + 1
            else
                j = mid
        }
        return i - 1
    }

    fun totalScore(startTime: Int, endTime: Int): Long {
        val r = solve(t, endTime)
        val l = solve(t, startTime - 1)
        return if (r < 0) 0 else x[r] - (if (l >= 0) x[l] else 0)
    }
}
