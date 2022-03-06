package com.ypwang.medium

class Solution2195 {
    fun minimalKSum(nums: IntArray, k: Int): Long {
        var sum = (k.toLong() + 1) * k / 2
        var last = k + 1
        for (n in nums.toSet().sorted()) {
            if (n < last)
                sum += (last++) - n
        }

        return sum
    }
}