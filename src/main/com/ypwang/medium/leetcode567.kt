package com.ypwang.medium

class Solution567 {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length)
            return false

        val cs1 = s1.groupBy { it }.mapValues { it.value.size }
        val cs2 = s2.take(s1.length).groupBy { it }.mapValues { it.value.size }.toMutableMap()

        if (cs1 == cs2)
            return true

        for (i in s1.length until s2.length) {
            cs2[s2[i]] = cs2.getOrDefault(s2[i], 0) + 1
            val r = s2[i - s1.length]

            if (cs2[r] == 1) cs2.remove(r)
            else cs2[r] = cs2[r]!! - 1

            if (cs1 == cs2)
                return true
        }

        return false
    }
}