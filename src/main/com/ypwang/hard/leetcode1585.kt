package com.ypwang.hard

class Solution1585 {
    fun isTransformable(s: String, t: String): Boolean {
        val cache = Array(10){ mutableListOf<Int>() }

        for ((i, c) in s.withIndex()) {
            cache[c - '0'].add(i)
        }

        for (c in t) {
            val i = c - '0'

            if (cache[i].isEmpty())
                return false

            for (j in 0 until i) {
                // cannot move bigger element right
                if (cache[j].isNotEmpty() && cache[j].first() < cache[i].first())
                    return false
            }

            cache[i].removeAt(0)
        }

        return true
    }
}