package com.ypwang.medium

class Solution3853 {
    fun mergeCharacters(s: String, k: Int): String {
        val window = mutableSetOf<Char>()

        val rst = StringBuilder()
        for (i in s.indices) {
            if (s[i] in window)
                continue

            rst.append(s[i])
            if (rst.length > k)
                window.remove(rst[rst.length-1-k])
            window.add(s[i])
        }

        return rst.toString()
    }
}

fun main() {
    println(Solution3853().mergeCharacters("aabca", 2))
}