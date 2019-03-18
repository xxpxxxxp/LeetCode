package com.ypwang.medium

class Solution80 {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        var cur = nums[0]
        var i = 0
        var j = 0

        while (j < nums.size) {
            var count = 2
            // copy < 2 element
            while (j < nums.size && nums[j] == cur && count > 0) {
                nums[i] = nums[j]
                i++
                j++
                count--
            }

            while (j < nums.size && nums[j] == cur) {
                j++
            }

            if (j < nums.size) {
                cur = nums[j]
            }
        }

        return i
    }
}

fun main(args: Array<String>) {
    println(Solution80().removeDuplicates(intArrayOf(0,0,1,1,1,1,2,3,3)))
}