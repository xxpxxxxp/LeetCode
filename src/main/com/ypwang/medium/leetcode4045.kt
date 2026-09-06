package com.ypwang.medium

class Solution4045 {
    fun countGroups(position: IntArray, speed: IntArray, distance: Int): Int {
        var res = 0
        val n = speed.size
        var p2 = Int.MAX_VALUE
        var s2 = p2
        for (i in n - 1 downTo 0) {
            val p = position[i]
            val s = speed[i]
            if (p2 - p > distance && s <= s2) {
                res += 1
                s2 = s
            }
            p2 = p
        }
        return res
    }
}
