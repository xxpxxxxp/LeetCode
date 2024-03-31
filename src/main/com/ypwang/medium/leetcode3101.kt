package com.ypwang.medium

class Solution3101 {
    fun countAlternatingSubarrays(nums: IntArray): Long {
        var rst = 0L
        var i = 0
        var j = 0
        while (j < nums.size) {
            while (j+1 < nums.size && nums[j] != nums[j+1])
                j++

            val l = j-i+1
            rst += l.toLong() * (l+1) / 2
            i = ++j
        }

        return rst
    }
}

fun main() {
    println(Solution3101().countAlternatingSubarrays(intArrayOf(0,1,1,1)))
    println(Solution3101().countAlternatingSubarrays(intArrayOf(1,0,1,0)))
}
