package com.ypwang.medium

class Solution3980 {
    fun minOperations(s1: String, s2: String): Int {
        if (s1 == "1" && s2 == "0")
            return -1

        val s = s1.toCharArray()
        var res = 0
        val n = s1.length

        for (i in 0 until n) {
            if (s[i] == s2[i])
                continue

            res++
            if (s[i] == '1') {
                if (i == n - 1)
                    res++
                else {
                    res += if (s[i + 1] == '0') 1 else 0
                    s[i + 1] = '0'
                }
            }
        }

        return res
    }
}
