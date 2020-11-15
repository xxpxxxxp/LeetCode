package com.ypwang.medium

class Solution1653 {
    fun minimumDeletions(s: String): Int {
        val ta = s.count { it == 'a' }
        if (ta == 0 || ta == s.length)
            return 0

        var rst = ta
        var ca = ta
        var cb = 0
        for (c in s) {
            if (c == 'a')
                ca--
            else
                cb++

            rst = minOf(rst, ca + cb)
        }

        return rst
    }
}

fun main() {
    println(Solution1653().minimumDeletions("b"))
    println(Solution1653().minimumDeletions("baababbaabbaaabaabbabbbabaaaaaabaabababaaababbb"))
    println(Solution1653().minimumDeletions("aababbab"))
    println(Solution1653().minimumDeletions("bbaaaaabb"))
}