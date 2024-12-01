package com.ypwang.easy

class Solution3370 {
    fun smallestNumber(n: Int): Int =
        (1 shl n.toString(2).length) - 1
}
