package com.ypwang.easy

class Solution1342 {
    fun numberOfSteps (num: Int): Int =
        num.toString(2).let { it.length + it.count { i -> i == '1' } - 1 }
}