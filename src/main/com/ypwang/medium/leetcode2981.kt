package com.ypwang.medium

class Solution2981 {
    fun maximumLength(s: String): Int {
        var count = 0
        var last = s[0]
        var ans = 0
        val ump = mutableMapOf<Char, MutableList<Int>>()
        for (c in s) {
            if (c == last)
                count++
            else {
                ump.getOrPut(last, { mutableListOf() }).add(count)
                count = 1
                last = c
            }
        }
        ump.getOrPut(last, { mutableListOf() }).add(count)

        for (value in ump.values) {
            var (l1, l2, l3) = (value + listOf(0, 0)).sortedDescending().take(3)
            if (l1 == l2 && l1 > l3) l2--

            if (l1 + l2 + l3 >= 3)
                ans = maxOf(ans, maxOf(l1 - 2, l2))
        }
        return if (ans != 0) ans else -1
    }
}
