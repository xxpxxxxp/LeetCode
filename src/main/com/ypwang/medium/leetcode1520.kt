package com.ypwang.medium

class Solution1520 {
    fun maxNumOfSubstrings(s: String): List<String> {
        val range = Array(26) { intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE) }

        for ((i, c) in s.withIndex()) {
            val j = c - 'a'
            range[j][0] = minOf(range[j][0], i)
            range[j][1] = maxOf(range[j][1], i)
        }

        fun checkSubstr(i: Int): Int {
            var right = range[s[i] - 'a'][1]
            var j = i
            while (j <= right) {
                if (range[s[j] - 'a'][0] < i)
                    return -1;
                right = maxOf(right, range[s[j] - 'a'][1])
                j++
            }
            return right
        }

        val rst = mutableListOf<String>()
        var right = -1
        for ((i, c) in s.withIndex()) {
            val j = c - 'a'
            if (i == range[j][0]) {
                val newRight = checkSubstr(i)
                if (newRight != -1) {
                    if (i <= right) {
                        rst.removeAt(rst.lastIndex)
                    }
                    rst.add(s.substring(i, newRight+1))
                    right = newRight
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1520().maxNumOfSubstrings("adefaddaccc"))
    println(Solution1520().maxNumOfSubstrings("abbaccd"))
}