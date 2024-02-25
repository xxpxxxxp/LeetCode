package com.ypwang.medium

class Solution3048 {
    fun earliestSecondToMarkIndices(nums: IntArray, changeIndices: IntArray): Int {
        val changes = changeIndices.map { it-1 }.toIntArray()
        var low = 0
        var high = changeIndices.size - 1
        while (low < high) {
            val mid = (low + high) / 2
            if (isPossible(nums, changes, mid))
                high = mid
            else
                low = mid + 1
        }
        return if (isPossible(nums, changes, low)) low + 1 else -1
    }

    private fun isPossible(nums: IntArray, changeIndices: IntArray, s: Int): Boolean {
        val n = nums.size
        val last = IntArray(n) { -1 }
        for (i in 0..s)
            last[changeIndices[i]] = i

        var marked = 0
        var operations = 0
        for (i in 0..s) {
            if (i == last[changeIndices[i]]) {
                if (nums[changeIndices[i]] > operations)
                    return false
                operations -= nums[changeIndices[i]]
                marked++
            } else {
                operations++
            }
        }
        return marked == n
    }
}
