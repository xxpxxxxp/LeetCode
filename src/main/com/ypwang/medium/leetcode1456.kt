package com.ypwang.medium

class Solution1456 {
    fun maxVowels(s: String, k: Int): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        var count = s.take(k).count { it in vowels }
        var max = count

        for (i in k until s.length) {
            if (s[i-k] in vowels) count--
            if (s[i] in vowels) count++
            max = maxOf(max, count)
        }

        return max
    }
}