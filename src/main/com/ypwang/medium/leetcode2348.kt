package com.ypwang.medium

class Solution2348 {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var rst = 0L
        var i = 0

        while (i < nums.size) {
            if (nums[i] == 0) {
                var j = i+1
                while (j < nums.size) {
                    if (nums[j] != 0)
                        break

                    j++
                }
                val len = j - i
                rst += len.toLong() * (len + 1) / 2

                i = j
            } else {
                i++
            }
        }

        return rst
    }
}

fun main() {
    println(Solution2348().zeroFilledSubarray(intArrayOf(1,3,0,0,2,0,0,4)))
}