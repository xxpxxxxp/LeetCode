package com.ypwang.medium

import java.math.BigInteger

class Solution3566 {
    fun checkEqualPartitions(nums: IntArray, target: Long): Boolean {
        val n = nums.size

        var ans = BigInteger.ONE
        val targetBigInt = target.toBigInteger()

        for (it in nums) {
            ans = ans.multiply(it.toBigInteger())
            if (ans > targetBigInt.multiply(targetBigInt))
                return false
        }

        if (ans != targetBigInt.multiply(targetBigInt))
            return false

        val maxi = (1 shl n)

        for (i in 1 until maxi - 1) {
            var sub = BigInteger.ONE
            for (j in 0 until n) {
                if ((i shr j) and 1 == 1) {
                    sub = sub.multiply(nums[j].toBigInteger())
                    if (sub > targetBigInt)
                        break
                }
            }
            if (sub == targetBigInt)
                return true
        }
        return false
    }
}
