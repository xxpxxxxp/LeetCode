package com.ypwang.medium

class Solution3514 {
    fun uniqueXorTriplets(nums: IntArray): Int {
        val freq = BooleanArray(2048)

        for (x in nums)
            for (y in nums)
                freq[x xor y] = true

        val ij = freq.withIndex().filter { it.value }.map { it.index }
        freq.fill(false)

        for (x in ij)
            for (y in nums)
                freq[x xor y] = true

        return freq.count { it }
    }
}
