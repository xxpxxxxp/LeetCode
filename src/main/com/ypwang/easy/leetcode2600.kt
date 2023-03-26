package com.ypwang.easy

class Solution2600 {
    fun kItemsWithMaximumSum(numOnes: Int, numZeros: Int, numNegOnes: Int, k: Int): Int {
        var k = k
        var rst = minOf(numOnes, k)
        k -= rst
        if (k <= 0)
            return rst

        val zeros = minOf(numZeros, k)
        k -= zeros
        if (k <= 0)
            return rst

        return rst - minOf(numNegOnes, k)
    }
}