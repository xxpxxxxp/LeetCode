package com.ypwang.easy

class Solution1732 {
    fun largestAltitude(gain: IntArray): Int =
        gain.fold(0 to 0) { (cur, max), i ->
            (cur + i) to maxOf(max, cur + i)
        }.second
}