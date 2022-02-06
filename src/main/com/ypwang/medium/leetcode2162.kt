package com.ypwang.medium

class Solution2162 {
    fun minCostSetTime(startAt: Int, moveCost: Int, pushCost: Int, targetSeconds: Int): Int {
        val mins = targetSeconds / 60
        val secs = targetSeconds % 60
        return minOf(
            cost(mins, secs, startAt, moveCost, pushCost),
            cost(mins - 1, secs + 60, startAt, moveCost, pushCost)
        )
    }

    private fun cost(mins: Int, secs: Int, startAt: Int, moveCost: Int, pushCost: Int): Int {
        if (mins > 99 || secs > 99 || mins < 0 || secs < 0) return Int.MAX_VALUE
        val s = (mins * 100 + secs).toString()
        var curr = '0' + startAt
        var res = 0
        for (i in s.indices) {
            if (s[i] != curr) {
                res += moveCost
                curr = s[i]
            }
            res += pushCost
        }
        return res
    }
}