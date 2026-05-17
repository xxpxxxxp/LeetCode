package com.ypwang.easy

class Solution3931 {
    fun isAdjacentDiffAtMostTwo(s: String): Boolean =
        (1 until s.length).all {
            Math.abs(s[it] - s[it-1]) <= 2
        }
}
