package com.ypwang.medium

class Solution3708 {
    fun longestSubarray(nums: IntArray): Int {
        var i = 0
        var j = 1
        var len = 1

        while (j < nums.lastIndex) {
            if (nums[j-1] + nums[j] != nums[j+1]) {
                len = maxOf(len, j - i + 1)
                i = j
            }

            j++
        }

        return maxOf(len, j-i+1)
    }
}

fun main() {
    println(Solution3708().longestSubarray(intArrayOf(5,2,7,9,16)))
    println(Solution3708().longestSubarray(intArrayOf(1,1,1,1,2,3,5,1)))
}