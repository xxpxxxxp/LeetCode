package com.ypwang.medium

class Solution4008 {
    fun minInitialStrength(monsters: IntArray, boosts: Array<IntArray>): Long {
        val n = monsters.size
        val diff = LongArray(n)
        for ((l, r, v) in boosts) {
            diff[r] += v.toLong()
            if (l > 0)
                diff[l - 1] -= v.toLong()
        }
        var res = 0L
        var bonus = 0L
        val norvelithx = monsters
        for (i in n - 1 downTo 0) {
            bonus += diff[i]
            if (res > 0)
                res += monsters[i].toLong()
            else
                res = maxOf(0L, monsters[i] - bonus)
        }
        return res
    }
}
