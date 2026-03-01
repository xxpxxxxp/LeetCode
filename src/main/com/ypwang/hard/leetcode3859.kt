package com.ypwang.hard

class Solution3859 {
    fun countSubarrays(nums: IntArray, k: Int, m: Int): Long {
        var l = 0
        var r = 0
        val set = mutableSetOf<Int>()
        val map = mutableMapOf<Int, Int>()
        var minCount = 0
        var res = 0L
        var toAdd = 0

        while (r < nums.size) {
            set.add(nums[r])
            map[nums[r]] = map.getOrDefault(nums[r], 0) + 1
            if (map[nums[r]] == m)
                minCount++

            while (set.size > k) {
                val leftVal = nums[l]
                if (map[leftVal] == m)
                    minCount--

                map[leftVal] = map[leftVal]!! - 1
                if (map[leftVal] == 0)
                    set.remove(leftVal)
                l++
                toAdd = 0
            }

            while (set.size == k && minCount == k) {
                if (map[nums[l]] == m)
                    break

                map[nums[l]] = map[nums[l]]!! - 1
                l++
                toAdd++
            }

            if (set.size == k && minCount == k)
                res += (toAdd + 1).toLong()

            r++
        }
        return res
    }
}
