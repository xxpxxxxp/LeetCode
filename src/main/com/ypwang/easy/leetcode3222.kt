package com.ypwang.easy

class Solution3222 {
    fun losingPlayer(x: Int, y: Int): String =
        if (minOf(x, y/4) % 2 == 1) "Alice" else "Bob"
}
