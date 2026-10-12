package com.ypwang.easy

class Solution4074 {
    fun maxProductPair(nums: IntArray, target: Int): IntArray {
        val n = nums.size
        var maxProduct = Int.MIN_VALUE
        val ans = intArrayOf(-1, -1)

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i != j && nums[i] + nums[j] == target && nums[i] > nums[j]) {
                    val product = nums[i] * nums[j]
                    if (product > maxProduct) {
                        maxProduct = product
                        ans[0] = i
                        ans[1] = j
                    }
                }
            }
        }

        return ans
    }
}
