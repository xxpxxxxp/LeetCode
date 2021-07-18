package com.ypwang.medium

class Solution1936 {
    fun addRungs(rungs: IntArray, dist: Int): Int {
        var cur = 0
        var count = 0

        for (r in rungs) {
            while (cur + dist < r) {
                count++
                cur+= dist
            }

            cur = r
        }

        return count
    }
}