package com.ypwang.easy

class Solution3794 {
    fun reversePrefix(s: String, k: Int): String =
        s.take(k).reversed() + s.drop(k)
}
