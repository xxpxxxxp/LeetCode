package com.ypwang.easy

class Solution2951 {
    fun findPeaks(mountain: IntArray): List<Int> =
        (1 until mountain.lastIndex).filter { mountain[it] > mountain[it-1] && mountain[it] > mountain[it+1] }
}