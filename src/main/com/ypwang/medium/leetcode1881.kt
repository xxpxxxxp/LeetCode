package com.ypwang.medium

class Solution1881 {
    fun maxValue(n: String, x: Int): String {
        val negative = n.first() == '-'
        var i = if (negative) 1 else 0

        while (i < n.length && (
                    ((n[i] - '0' <= x) && negative) ||
                            ((n[i] - '0' >= x) && !negative)
                    ))
            ++i

        return n.substring(0, i) + x.toString() + n.substring(i)
    }
}

fun main() {
    println(Solution1881().maxValue("99", 9))
    println(Solution1881().maxValue("-13", 2))
}