package com.ypwang.medium

class Solution2028 {
    fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
        val total = mean * (rolls.size + n) - rolls.sum()
        if (total < n || total > 6 * n)
            return intArrayOf()

        val m = total / n
        val y = total - m * n
        val rst = IntArray(n) { m }
        for (i in 0 until y)
            rst[i] = m+1

        return rst
    }
}