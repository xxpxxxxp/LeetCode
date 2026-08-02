package com.ypwang.medium

class Solution4012 {
    fun countTasks(tasks: IntArray, shifts: IntArray): IntArray {
        val n = tasks.size
        val pref = LongArray(n + 1)

        for (i in 0 until n)
            pref[i + 1] = pref[i] + tasks[i].toLong()

        var cur = 0L
        val res = IntArray(shifts.size)

        for (i in shifts.indices) {
            cur += shifts[i].toLong()

            if (cur >= pref[n]) {
                res[i] = 0
                cur = 0L
            } else
                res[i] = n - (upperBound(pref, cur) - 1)
        }

        return res
    }

    private fun upperBound(arr: LongArray, target: Long): Int {
        var left = 0
        var right = arr.size
        while (left < right) {
            val mid = (left + right) / 2
            if (arr[mid] <= target)
                left = mid + 1
            else
                right = mid
        }
        return left
    }
}
