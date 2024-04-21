package com.ypwang.medium

class Solution3115 {
    fun maximumPrimeDifference(nums: IntArray): Int {
        var pre = -1
        var rst = 0

        for ((i, v) in nums.withIndex()) {
            if (isPrime(v)) {
                if (pre == -1)
                    pre = i

                rst = maxOf(rst, i - pre)
            }
        }

        return rst
    }

    private fun isPrime(n: Int): Boolean {
        if (n < 2)
            return false
        var i = 2
        while (i <= Math.sqrt(n.toDouble())) {
            if (n % i == 0)
                return false
            i++
        }
        return true
    }
}
