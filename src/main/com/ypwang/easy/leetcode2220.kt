package com.ypwang.easy

class Solution2220 {
    fun minBitFlips(start: Int, goal: Int): Int =
        Integer.bitCount(start xor goal)
}