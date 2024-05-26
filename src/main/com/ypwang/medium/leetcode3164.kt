package com.ypwang.medium

class Solution3164 {
    fun numberOfPairs(nums1: IntArray, nums2: IntArray, k: Int): Long {
        var rst = 0L
        val freq = mutableMapOf<Int, Int>()

        nums2.forEach { n -> freq[n] = freq.getOrDefault(n, 0) + 1 }

        for (n in nums1) {
            if (n % k != 0)
                continue

            val sr = Math.sqrt(n.toDouble() / k).toInt()
            val t = n / k
            for (i in 1..sr) {
                if (t % i == 0) {
                    rst += freq.getOrDefault(i, 0)
                    if (i != t / i)
                        rst += freq.getOrDefault(t / i, 0)
                }
            }
        }
        return rst
    }
}
