package com.ypwang.medium

class Solutio2461 {
    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        if (nums.size < k)
            return 0

        var sum = 0L
        val mp = mutableMapOf<Int, Int>()

        for (i in 0 until k) {
            sum += nums[i]
            mp[nums[i]] = mp.getOrDefault(nums[i], 0) + 1
        }

        var max = 0L
        for (i in k until nums.size) {
            if (mp.size == k)
                max = maxOf(max, sum)

            sum -= nums[i-k]
            sum += nums[i]

            mp[nums[i-k]] = mp[nums[i-k]]!! - 1
            if (mp[nums[i-k]] == 0)
                mp.remove(nums[i-k])

            mp[nums[i]] = mp.getOrDefault(nums[i], 0) + 1
        }

        if (mp.size == k)
            max = maxOf(max, sum)

        return max
    }
}