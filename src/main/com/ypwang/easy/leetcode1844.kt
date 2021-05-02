package com.ypwang.easy

class Solution1844 {
    fun replaceDigits(s: String): String {
        val arr = CharArray(s.length)

        for (i in s.indices) {
            arr[i] = if (i % 2 == 0)
                s[i]
            else
                s[i] + (s[i-1] - '0')
        }

        return arr.joinToString("")
    }
}