package com.ypwang.medium

class Solution3849 {
    fun maximumXor(s: String, t: String): String {
        val available = t.groupBy { it }.map { it.key - '0' to it.value.size }.toMap().filter { it.value > 0 }.toMutableMap()
        val rst = CharArray(s.length)

        var i = 0
        while (i < s.length) {
            val m = 1 xor (s[i] - '0')
            if (m !in available)
                break

            available[m] = available[m]!! - 1
            if (available[m] == 0)
                available.remove(m)

            rst[i] = '1'
            i++
        }

        if (i != s.length) {
            val only = available.keys.single()
            for (j in i until s.length)
                rst[j] = '0' + (only xor (s[j] - '0'))
        }

        return String(rst)
    }
}
