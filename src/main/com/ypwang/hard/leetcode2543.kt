package com.ypwang.hard

class Solution2543 {
    private fun gcd(a: Int, b: Int): Int {
        return if (a == 0) b else gcd(b % a, a)
    }

    fun isReachable(targetX: Int, targetY: Int): Boolean {
        val g = gcd(targetX, targetY)
        return g and (g-1) == 0
    }
}