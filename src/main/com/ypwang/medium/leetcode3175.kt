package com.ypwang.medium

class Solution3175 {
    fun findWinningPlayer(skills: IntArray, k: Int): Int {
        var b = skills[0]
        var cur = 0
        var res = 0
        for (i in 1 until skills.size) {
            if (skills[i] > b) {
                b = skills[i]
                cur = 0
                res = i
            }
            if (++cur >= k)
                break
        }
        return res
    }
}
