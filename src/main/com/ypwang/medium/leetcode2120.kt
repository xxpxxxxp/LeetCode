package com.ypwang.medium

class Solution2120 {
    fun executeInstructions(n: Int, startPos: IntArray, s: String): IntArray {
        val rst = IntArray(s.length)
        for (i in s.indices) {
            var (y, x) = startPos
            var j = i
            while (j < s.length) {
                when (s[j]) {
                    'L' -> x--
                    'R' -> x++
                    'U' -> y--
                    'D' -> y++
                }

                if (x !in 0 until n || y !in 0 until n)
                    break

                j++
            }

            rst[i] = j - i
        }

        return rst
    }
}