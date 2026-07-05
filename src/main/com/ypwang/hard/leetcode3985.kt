package com.ypwang.hard

class Solution3985 {
    fun getSum(nums: IntArray): Long {
        val n = nums.size

        val prefix = LongArray(n + 1)
        for (i in 0 until n)
            prefix[i + 1] = prefix[i] + nums[i]

        var res = 0L

        val d1 = IntArray(n)
        var left = 0
        var right = -1

        for (i in 0 until n) {
            var k = if (i > right) 1 else minOf(d1[left + right - i], right - i + 1)

            while (i - k >= 0 && i + k < n && nums[i - k] == nums[i + k])
                k++

            d1[i] = k

            val l = i - k + 1
            val r = i + k - 1
            res = maxOf(res, prefix[r + 1] - prefix[l])

            if (r > right) {
                left = l
                right = r
            }
        }

        val d2 = IntArray(n)
        left = 0
        right = -1

        for (i in 0 until n) {
            var k = if (i > right) 0 else minOf(d2[left + right - i + 1], right - i + 1)
            while (i - k - 1 >= 0 && i + k < n && nums[i - k - 1] == nums[i + k])
                k++

            d2[i] = k

            if (k > 0) {
                val l = i - k
                val r = i + k - 1
                res = maxOf(res, prefix[r + 1] - prefix[l])
            }

            if (i + k - 1 > right) {
                left = i - k
                right = i + k - 1
            }
        }

        return res
    }
}
