package com.ypwang.medium

class Solution3694 {
    fun distinctPoints(s: String, k: Int): Int {
        val set = mutableSetOf<Int>()
        val w = IntArray(2)

        fun move(c: Char, reverse: Boolean = false) {
            when (c) {
                'U' -> if (reverse) w[0]-- else w[0]++
                'D' -> if (reverse) w[0]++ else w[0]--
                'L' -> if (reverse) w[1]-- else w[1]++
                'R' -> if (reverse) w[1]++ else w[1]--
            }
        }

        fun hash(c: IntArray): Int =
            (c[0] shl 16) or (c[1] and 0xFFFF)

        for (i in 0 until k)
            move(s[i])

        set.add(hash(w))

        for (i in k until s.length) {
            move(s[i-k], true)
            move(s[i])
            set.add(hash(w))
        }

        return set.size
    }
}

fun main() {
    println(Solution3694().distinctPoints("URD", 2))
}