package com.ypwang.medium

class Solution1780 {
    fun checkPowersOfThree(n: Int): Boolean = n.toString(3).all { it - '0' < 2 }
}