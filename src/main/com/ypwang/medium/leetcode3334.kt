package com.ypwang.medium

class Solution3334 {
    private fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) a else gcd(b, a % b)
    }

    private fun gcdOfArray(arr: IntArray): Long {
        var result = arr[0].toLong()
        for (num in arr) {
            result = gcd(result, num.toLong())
        }
        return result
    }

    private fun lcm(a: Long, b: Long): Long {
        return (a * b) / gcd(a, b)
    }

    private fun lcmOfArray(arr: IntArray): Long {
        var result = arr[0].toLong()
        for (num in arr) {
            result = lcm(result, num.toLong())
        }
        return result
    }

    fun maxScore(nums: IntArray): Long {
        val n = nums.size
        if (n == 1) {
            return (nums[0].toLong() * nums[0])
        }

        val totalGCD = gcdOfArray(nums)
        val totalLCM = lcmOfArray(nums)
        var maxScore = totalGCD * totalLCM

        for (i in 0 until n) {
            val tempArray = IntArray(n - 1)
            var index = 0
            for (j in 0 until n) {
                if (j != i) {
                    tempArray[index++] = nums[j]
                }
            }

            val currentGCD = gcdOfArray(tempArray)
            val currentLCM = lcmOfArray(tempArray)
            val currentScore = currentGCD * currentLCM

            maxScore = maxOf(maxScore, currentScore)
        }

        return maxScore
    }
}
