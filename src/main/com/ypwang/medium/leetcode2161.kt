package com.ypwang.medium

class Solution2161 {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        var low = 0
        var same = 0
        for (n in nums) {
            if (n == pivot)
                same++
            else if (n < pivot)
                low++
        }

        var high = low + same
        same = low
        low = 0
        val rst = IntArray(nums.size)
        for (n in nums) {
            if (n == pivot)
                rst[same++] = n
            else if (n < pivot)
                rst[low++] = n
            else
                rst[high++] = n
        }

        return rst
    }
}