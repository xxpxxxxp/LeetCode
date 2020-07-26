package com.ypwang.medium

class Solution1529 {
    fun minFlips(target: String): Int =
            target.fold(0){ count, c -> count + (if (count % 2 == c - '0') 0 else 1) }
}