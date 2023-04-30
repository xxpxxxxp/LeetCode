package com.ypwang.hard

class Solution2663 {
    fun smallestBeautifulString(s: String, k: Int): String {
        val cs = s.toCharArray()

        fun valid(i: Int): Boolean =
            (i < 1 || cs[i] != cs[i-1]) && (i < 2 || cs[i] != cs[i-2])

        for (i in cs.lastIndex downTo 0) {
            cs[i]++
            while (!valid(i))
                cs[i]++

            if (cs[i] < 'a' + k) {
                for (j in i+1 until cs.size) {
                    cs[j] = 'a'
                    while (!valid(j))
                        cs[j]++
                }
                return cs.joinToString("")
            }
        }

        return ""
    }
}
