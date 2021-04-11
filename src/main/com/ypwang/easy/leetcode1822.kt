package com.ypwang.easy

class Solution1822 {
    fun arraySign(nums: IntArray): Int {
        var rst = 1
        for (num in nums) {
            when (num) {
                0 -> return 0
                else ->
                    if (num < 0)
                        rst *= -1
            }
        }

        return rst
    }
}