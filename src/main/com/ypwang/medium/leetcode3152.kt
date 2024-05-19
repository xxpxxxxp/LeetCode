package com.ypwang.medium

class Solution3152 {
    fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
        val arr = IntArray(nums.size)
        for (i in 1 until arr.size)
            arr[i] = arr[i-1] + if ((nums[i-1] xor nums[i]) and 0x1 == 1) 1 else 0

        return queries.map { (i, j) -> arr[j] - arr[i] == j-i }.toBooleanArray()
    }
}
