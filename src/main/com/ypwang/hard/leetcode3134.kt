package com.ypwang.hard

class Solution3134 {
    fun medianOfUniquenessArray(nums: IntArray): Int {
        fun atmost(k: Int): Long {
            var res = 0L
            val count = mutableMapOf<Int, Int>()
            var i = 0
            for (j in nums.indices) {
                count[nums[j]] = count.getOrDefault(nums[j], 0) + 1
                while (count.size > k) {
                    count[nums[i]] = count[nums[i]]!! - 1
                    if (count[nums[i]] == 0)
                        count.remove(nums[i])
                    i++
                }
                res += j - i + 1
            }
            return res
        }

        val n = nums.size
        var left = 1
        var right = n
        val total = n.toLong() * (n + 1) / 2
        while (left < right) {
            val k = (left + right) / 2
            if (atmost(k) * 2 >= total)
                right = k
            else
                left = k + 1
        }
        return left
    }
}
