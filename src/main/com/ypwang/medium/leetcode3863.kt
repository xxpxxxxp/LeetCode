package com.ypwang.medium

class Solution3863 {
    fun minOperations(s: String): Int {
        val sorted = s.toCharArray().sorted().joinToString("")
        if (s == sorted)
            return 0

        if (s.length == 2)
            return -1

        val min = sorted.first()
        val max = sorted.last()

        if (s[0] == max && s.last() == min)
            return if (s.slice(1 until s.length - 1).any { it == min || it == max })
                2
            else 3

        if (s[0] == min || s.last() == max)
            return 1


        return 2
    }
}
