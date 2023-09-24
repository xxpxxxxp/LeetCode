package com.ypwang.medium

class Solution2841 {
    fun maxSum(nums: List<Int>, m: Int, k: Int): Long {
        if (nums.size < k || m > k)
            return 0L

        var sum = 0L
        var rst = 0L
        val count = mutableMapOf<Int, Int>()

        for (i in 0 until k) {
            sum += nums[i]
            count[nums[i]] = count.getOrDefault(nums[i], 0) + 1
        }

        if (count.size >= m)
            rst = sum

        for (i in k until nums.size) {
            sum += nums[i]
            sum -= nums[i-k]
            count[nums[i]] = count.getOrDefault(nums[i], 0) + 1
            count[nums[i-k]] = count[nums[i-k]]!! - 1
            if (count[nums[i-k]] == 0)
                count.remove(nums[i-k])

            if (count.size >= m)
                rst = maxOf(rst, sum)
        }

        return rst
    }
}