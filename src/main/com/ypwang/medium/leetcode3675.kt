package com.ypwang.medium

class Solution3675 {
    fun minOperations(s: String): Int =
        s.map { (26 - (it - 'a')) % 26 }.max()
}
