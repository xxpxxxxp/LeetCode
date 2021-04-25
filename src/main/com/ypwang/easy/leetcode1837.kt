package com.ypwang.easy

class Solution1837 {
    fun sumBase(n: Int, k: Int): Int = n.toString(k).map { it - '0' }.sum()
}