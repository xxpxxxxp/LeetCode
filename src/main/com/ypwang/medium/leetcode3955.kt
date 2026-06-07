package com.ypwang.medium

class Solution3955 {
    fun generateValidStrings(n: Int, k: Int): List<String> {
        val list = mutableListOf<String>()
        fun help(i: Int, n: Int, k: Int, cost: Int, prev: Boolean, stb: StringBuilder) {
            if (cost > k)
                return

            if (i == n) {
                list.add(stb.toString())
                return
            }

            stb.append('0')
            help(i + 1, n, k, cost, false, stb)
            stb.deleteCharAt(stb.length - 1)
            if (!prev) {
                stb.append('1')
                help(i + 1, n, k, cost + i, true, stb)
                stb.deleteCharAt(stb.length - 1)
            }
        }

        help(0, n, k, 0, false, StringBuilder())
        return list
    }
}
