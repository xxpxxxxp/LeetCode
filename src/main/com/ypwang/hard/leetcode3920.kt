package com.ypwang.hard

class Solution3920 {
    fun maxFixedPoints(nums: IntArray): Int {
        val s = mutableListOf<Int>()
        val B = mutableListOf<IntArray>()
        for (i in nums.indices)
            if (i >= nums[i])
                B.add(intArrayOf(i - nums[i], nums[i]))

        B.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })

        // LIS
        for (p in B) {
            val x = p[1]
            var left = 0
            var right = s.size
            while (left < right) {
                val mid = left + (right - left) / 2
                if (s[mid] >= x)
                    right = mid
                else left = mid + 1
            }
            if (left == s.size)
                s.add(x)
            else
                s[left] = x
        }
        return s.size
    }
}
