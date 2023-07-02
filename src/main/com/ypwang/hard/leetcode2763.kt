package com.ypwang.hard

class Solution2763 {
    fun sumImbalanceNumbers(nums: IntArray): Int {
        val n = nums.size
        val left = IntArray(n)
        val seen = IntArray(n + 10) { -1 }
        for (i in 0 until n) {
            left[i] = maxOf(seen[nums[i] + 1], seen[nums[i]])
            seen[nums[i]] = i
        }
        seen.fill(n)
        var rst = 0
        for (i in n - 1 downTo 0) {
            seen[nums[i]] = i
            rst += (i - left[i]) * (seen[nums[i] + 1] - i)
        }
        return rst - n * (n + 1) / 2
    }
}