package com.ypwang.medium

class Solution3224 {
    fun minChanges(nums: IntArray, k: Int): Int {
        val s = mutableMapOf<Int, Int>()
        val n = nums.size
        val f = IntArray(k + 1)
        for (i in 0 until n / 2) {
            val min = minOf(nums[i], nums[n - i - 1])
            val max = maxOf(nums[i], nums[n - i - 1])
            s[max - min] = s.getOrDefault(max - min, 0) + 1
            f[maxOf(k - min, max)]++
        }
        for (i in k - 1 downTo 0)
            f[i] += f[i + 1]

        var ans = n
        for (x in s.keys) {
            val one = f[x] - s[x]!!
            val two = n / 2 - f[x]
            ans = minOf(ans, one + two * 2)
        }
        return ans
    }
}
