package com.ypwang.medium

class Solution2745 {
    fun longestString(x: Int, y: Int, z: Int): Int =
        (minOf(x + 1, y) + minOf(x, y + 1) + z) * 2
}