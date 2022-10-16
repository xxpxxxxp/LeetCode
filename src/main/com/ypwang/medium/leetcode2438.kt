package com.ypwang.medium

class Solution2438 {
    fun productQueries(n: Int, queries: Array<IntArray>): IntArray {
        val mod = 1000000007
        val pow = mutableListOf<Int>()
        for (i in 0 until 32) {
            if (n and (1 shl i) > 0)
                pow.add(1 shl i)
        }

        val result = IntArray(queries.size)
        for ((i, arr) in queries.withIndex()) {
            var res = 1L
            for (j in arr[0]..arr[1])
                res = res * pow[j] % mod
            result[i] = res.toInt()
        }
        return result
    }
}