package com.ypwang.hard

class Solution3574 {
    fun maxGCDScore(nums: IntArray, k: Int): Long {
        val n = nums.size
        val B = IntArray(n)
        var res = 0L

        for (i in 0 until n) {
            B[i] = nums[i] and -nums[i]
            nums[i] /= B[i]
        }

        for (i in 0 until n) {
            var a = nums[i]
            var count = 0
            var minPow = Int.MAX_VALUE
            for (j in i until n) {
                a = gcd(a, nums[j])
                if (B[j] < minPow) {
                    minPow = B[j]
                    count = 0
                }
                if (B[j] == minPow)
                    count++

                res = maxOf(res, 1L * a * minPow * (if (count <= k) 2 else 1) * (j - i + 1))
            }
        }
        return res
    }

    private fun gcd(a: Int, b: Int): Int =
        if (b == 0) a else gcd(b, a % b)
}
