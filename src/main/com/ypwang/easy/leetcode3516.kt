package com.ypwang.easy

class Solution3516 {
    fun findClosest(x: Int, y: Int, z: Int): Int {
        val dx = Math.abs(x - z)
        val dy = Math.abs(y - z)
        return if (dx == dy)
            0
        else if (dx < dy)
            1
        else 2
    }
}