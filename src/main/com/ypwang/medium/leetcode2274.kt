package com.ypwang.medium

class Solution2274 {
    fun maxConsecutive(bottom: Int, top: Int, special: IntArray): Int {
        special.sort()
        return maxOf(
            special.first() - bottom,
            top - special.last(),
            (0 until special.lastIndex).map { special[it+1] - special[it] - 1 }.maxOrNull() ?: 0
        )
    }
}