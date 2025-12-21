package com.ypwang.easy

class Solution3783 {
    fun mirrorDistance(n: Int): Int =
        Math.abs(n - n.toString().reversed().toInt())
}
