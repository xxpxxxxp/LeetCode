package com.ypwang.medium

class Solution3969 {
    private fun firstDigit(n: Long): Int {
        var n = n
        while (n >= 10)
            n /= 10

        return n.toInt()
    }

    fun countValidSubarrays(nums: IntArray, x: Int): Int {
        val n = nums.size

        val pref = LongArray(n + 1)
        for (i in 0 until n)
            pref[i + 1] = pref[i] + nums[i]

        var ans = 0

        for (i in 0 until n) {
            for (j in i until n) {
                val sum = pref[j + 1] - pref[i]

                if (sum % 10 != x.toLong())
                    continue

                if (firstDigit(sum) == x)
                    ans++
            }
        }

        return ans
    }
}
