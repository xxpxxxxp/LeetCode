package com.ypwang.medium

class Solution846 {
    fun isNStraightHand(hand: IntArray, W: Int): Boolean {
        if (hand.size % W != 0) {
            return false
        }

        val m = hand.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        for (i in 0 until hand.size / W) {
            if (m.isEmpty()) {
                return false
            }
            val min = m.minBy { it.key }!!.key
            for (j in 0 until W) {
                val cur = min + j
                if (cur !in m) {
                    return false
                }

                if (m[cur] == 1) {
                    m.remove(cur)
                } else {
                    m[cur] = m[cur]!! - 1
                }
            }
        }

        return true
    }
}

fun main() {
    println(Solution846().isNStraightHand(intArrayOf(5, 1), 1))
}