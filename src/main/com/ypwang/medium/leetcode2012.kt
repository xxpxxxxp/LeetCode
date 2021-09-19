package com.ypwang.medium

class Solution2012 {
    fun sumOfBeauties(nums: IntArray): Int {
        var rst = 0

        val arr = IntArray(nums.size){ nums.last() }
        var min = nums.last()
        for (i in nums.lastIndex-1 downTo 1) {
            arr[i] = min
            min = minOf(min, nums[i])
        }

        var max = nums[0]
        for (i in 1 until nums.lastIndex) {
            if (nums[i-1] < nums[i] && nums[i] < nums[i+1])
                rst++

            if (max < nums[i] && nums[i] < arr[i])
                rst++

            max = maxOf(max, nums[i])
        }

        return rst
    }
}

fun main() {
    println(Solution2012().sumOfBeauties(intArrayOf(2,4,6,4)))
}