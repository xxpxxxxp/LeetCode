package com.ypwang.medium

import java.math.BigInteger

class Solution2961 {
    fun getGoodIndices(variables: Array<IntArray>, target: Int): List<Int> =
        variables.withIndex().filter { (_, arr) ->
            val (a, b, c, m) = arr
            BigInteger.valueOf(a.toLong())
                .modPow(BigInteger.valueOf(b.toLong()), BigInteger.valueOf(10L))
                .modPow(BigInteger.valueOf(c.toLong()), BigInteger.valueOf(m.toLong()))
                .toInt() == target
        }.map { it.index }
}