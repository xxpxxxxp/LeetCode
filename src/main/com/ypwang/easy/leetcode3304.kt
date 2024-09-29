package com.ypwang.easy

class Solution3304 {
    fun kthCharacter(k: Int): Char =
        'a' + (Integer.bitCount(k-1) % 26)
}
