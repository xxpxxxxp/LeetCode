package com.ypwang.medium

class Solution2849 {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        val dx = Math.abs(sx - fx)
        val dy = Math.abs(sy - fy)
        val d = t - maxOf(dx, dy)
        return d >= 0 && !(d == 1 && dx == 0 && dy == 0)
    }
}