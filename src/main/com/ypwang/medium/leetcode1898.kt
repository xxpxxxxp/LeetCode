package com.ypwang.medium

import java.lang.StringBuilder

class Solution1898 {
    private fun isSubsequence(s: String, p: String): Boolean {
        var i = 0
        var j = 0

        while (i < s.length && j < p.length) {
            if (s[i] == p[j]) {
                j++
            }

            i++
        }

        return j == p.length
    }

    fun maximumRemovals(s: String, p: String, removable: IntArray): Int {
        var left = 0
        var right = removable.size

        while (left < right) {
            val mid = (left + right) / 2
            val ridx = BooleanArray(s.length)
            for (i in 0..mid)
                if (i < s.length)
                    ridx[removable[i]] = true

            val sb = StringBuilder()
            for (i in s.indices) {
                if (!ridx[i])
                    sb.append(s[i])
            }

            if (isSubsequence(sb.toString(), p))
                left = mid + 1
            else
                right = mid
        }

        return left
    }
}

fun main() {
    println(Solution1898().maximumRemovals("abcacb",
        "ab",
        intArrayOf(3,1,0)))
}