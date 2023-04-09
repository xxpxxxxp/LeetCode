package com.ypwang.easy

class Solution2614 {
    fun diagonalPrime(nums: Array<IntArray>): Int {
        var max = 0
        for (i in nums.indices) {
            if (isPrime(nums[i][i]))
                max = maxOf(max, nums[i][i])
            if (isPrime(nums[nums.size - i - 1][i]))
                max = maxOf(max, nums[nums.size - i - 1][i])
        }
        return max
    }

    fun isPrime(n: Int): Boolean {
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