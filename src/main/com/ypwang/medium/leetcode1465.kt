package com.ypwang.medium

class Solution1465 {
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        horizontalCuts.sort()
        verticalCuts.sort()

        var hm = maxOf(horizontalCuts.first(), h - horizontalCuts.last())
        for (i in 0 until horizontalCuts.lastIndex) {
            hm = maxOf(hm, horizontalCuts[i+1] - horizontalCuts[i])
        }

        var wm = maxOf(verticalCuts.first(), w - verticalCuts.last())
        for (i in 0 until verticalCuts.lastIndex) {
            wm = maxOf(wm, verticalCuts[i+1] - verticalCuts[i])
        }

        return (hm.toLong() * wm % 1000000007).toInt()
    }
}