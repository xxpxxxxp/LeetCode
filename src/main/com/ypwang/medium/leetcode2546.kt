package com.ypwang.medium

class Solution2546 {
    fun makeStringsEqual(s: String, target: String): Boolean =
        s.contains('1') == target.contains('1')
}