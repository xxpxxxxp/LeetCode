package com.ypwang.easy

class Solution {
    fun losingPlayer(x: Int, y: Int): String =
        if (minOf(x, y/4) % 2 == 1) "Alice" else "Bob"
}
