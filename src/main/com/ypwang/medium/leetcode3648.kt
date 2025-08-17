package com.ypwang.medium

class Solution3648 {
    fun minSensors(n: Int, m: Int, k: Int): Int {
        val side = 2 * k + 1
        val rows = (n + side - 1) / side
        val cols = (m + side - 1) / side
        return rows * cols
    }
}
