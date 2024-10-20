package com.ypwang.medium

class Solution3325 {
    fun numberOfSubstrings(s: String, k: Int): Int {
        var count = IntArray(26)
        var rst = 0

        var i = 0
        var j = 0
        var satisfied = false
        while (i < s.length) {
            while (!satisfied && j < s.length) {
                val t = s[j++]-'a'
                count[t]++
                if (count[t] >= k) {
                    satisfied = true
                    break
                }
            }
            if (!satisfied)
                break

            rst += s.length - j + 1
            val t = s[i++]-'a'
            count[t]--
            if (count.all { it < k })
                satisfied = false
        }

        return rst
    }
}
