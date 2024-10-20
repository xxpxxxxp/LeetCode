package com.ypwang.medium

class Solution3326 {
    fun minOperations(nums: IntArray): Int {
        var rst = 0
        for (i in nums.size - 1 downTo 1) {
            if (nums[i] < nums[i - 1]) {
                nums[i - 1] = findNum(nums[i], nums[i - 1])
                if (nums[i - 1] == -1)
                    return -1
                rst++
            }
        }
        return rst
    }

    private fun findNum(n1: Int, n2: Int): Int =
        (n1 downTo 2).firstOrNull { n2 % it == 0 } ?: -1
}
