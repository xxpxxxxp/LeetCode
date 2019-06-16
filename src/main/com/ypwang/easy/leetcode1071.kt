package com.ypwang.easy

class Solution1017 {
    fun gcdOfStrings(str1: String, str2: String): String {
        val (short, long) = if (str1.length > str2.length) (str2 to str1) else (str1 to str2)

        for (i in short.length downTo 1) {
            if (short.length % i == 0 && long.length % i == 0) {
                val segment = short.substring(0, i)

                if (segment.repeat(short.length / i) == short && segment.repeat(long.length / i) == long)
                    return segment
            }
        }

        return ""
    }
}