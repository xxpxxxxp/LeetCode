package com.ypwang.medium

class Solution3551 {
    fun solve(nums: IntArray, arr: IntArray): Int {
        val n = arr.size
        val map = nums.withIndex().associate { it.value to it.index }

        val v = BooleanArray(n)
        var ans = 0

        for (i in 0 until n) {
            if (v[i] || nums[i] == arr[i])
                continue

            var size = 0
            var j = i

            while (!v[j]) {
                v[j] = true
                j = map[arr[j]]!!
                size++
            }

            if (size > 1)
                ans += size - 1
        }
        return ans
    }

    fun minSwaps(nums: IntArray): Int =
        solve(nums, nums.sortedWith(compareBy<Int> { it.toString().map { i -> i - '0' }.sum() }.thenBy { it }).toIntArray())
}
