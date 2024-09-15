package com.ypwang.easy

class Solution3285 {
    fun stableMountains(height: IntArray, threshold: Int): List<Int> =
        (1 until height.size).filter { height[it-1] > threshold }
}
