package com.ypwang.easy

class Solution3456 {
    fun hasSpecialSubstring(s: String, k: Int): Boolean {
        val map = s.substring(0, k).groupBy { it }.mapValues { it.value.size }.toMutableMap()
        if (map.size == 1 && (k >= s.length || s[k-1] != s[k]))
            return true

        for (i in k until s.length) {
            map[s[i-k]] = map[s[i-k]]!! - 1
            if (map[s[i-k]] == 0)
                map.remove(s[i-k])

            map[s[i]] = map.getOrDefault(s[i], 0) + 1
            if (map.size == 1 &&
                s[i-k] != s[i-k+1] &&
                (i+1 >= s.length || s[i] != s[i+1])
                )
                return true
        }

        return false
    }
}

fun main() {
    println(Solution3456().hasSpecialSubstring("ccc", 2))
}