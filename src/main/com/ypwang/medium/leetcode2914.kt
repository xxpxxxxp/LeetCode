package com.ypwang.medium

class Solution2914 {
    fun minChanges(s: String): Int =
        (0 until s.length / 2).count { s[2 * it] != s[2 * it+1] }
}
