package com.ypwang.medium

class Solution3366 {
    fun minArraySum(nums: IntArray, k: Int, op1: Int, op2: Int): Int {
        val dp = Array(nums.size) { Array(op1 + 1) { IntArray(op2 + 1) { -1 } }  }
        return sub(dp, nums, 0, k, op1, op2)
    }

    private fun sub(dp: Array<Array<IntArray>>, nums: IntArray, i: Int, k: Int, op1: Int, op2: Int): Int {
        if (i == nums.size)
            return 0
        if (dp[i][op1][op2] == -1) {
            var res = sub(dp, nums, i + 1, k, op1, op2) + nums[i]
            if (nums[i] >= k && op2 > 0) {
                res = minOf(res, sub(dp, nums, i + 1, k, op1, op2 - 1) + nums[i] - k)
                var v = (nums[i] + 1) / 2
                v = if (v < k) (nums[i] - k + 1) / 2 else v - k
                if (op1 > 0)
                    res = minOf(res, sub(dp, nums, i + 1, k, op1 - 1, op2 - 1) + v)
            }
            if (op1 > 0)
                res = minOf(res, sub(dp, nums, i + 1, k, op1 - 1, op2) + (nums[i] + 1) / 2)
            dp[i][op1][op2] = res
        }

        return dp[i][op1][op2]
    }
}

fun main() {
    println(Solution3366().minArraySum(
        intArrayOf(2,4,3), 3, 2, 1
    ))
}