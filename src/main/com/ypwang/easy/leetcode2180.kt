package com.ypwang.easy

class Solution2180 {
    fun countEven(num: Int): Int =
        (1..num).count { it.toString().map { i -> i.toInt() }.sum() % 2 == 0 }
}