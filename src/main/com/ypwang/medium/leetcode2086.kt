package com.ypwang.medium

class Solution2086 {
    fun minimumBuckets(street: String): Int {
        if (street == "H" || street.startsWith("HH") || street.endsWith("HH") || street.contains("HHH"))
            return -1

        var i = 0
        var c = 0
        while (i < street.length) {
            i = street.indexOf("H.H", i)
            if (i >= 0)
                c++
            else
                break

            i += 3
        }

        return street.count { it == 'H' } - c
    }
}