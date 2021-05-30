package com.ypwang.easy

class Solution1876 {
    fun countGoodSubstrings(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        var count = 0
        s.take(3).forEach { map[it] = map.getOrDefault(it, 0) + 1 }
        if (map.size == 3)
            count++

        for (i in 3 until s.length) {
            map[s[i]] = map.getOrDefault(s[i], 0) + 1
            map[s[i-3]] = map[s[i-3]]!! - 1
            if (map[s[i-3]]!! == 0)
                map.remove(s[i-3])

            if (map.size == 3)
                count++
        }

        return count
    }
}