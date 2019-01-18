package com.ypwang.medium

class Solution611 {
    fun triangleNumber(nums: IntArray): Int {
        nums.sort()

        var count = 0
        for (i in 0 until nums.size - 2) {
            for (j in i+1 until nums.size - 1) {
                var find = nums.binarySearch(nums[i] + nums[j])
                find = minOf(if (find >= 0) find else -find - 1, nums.size)

                if (find > j) {
                    count += find - j - 1
                } else if (find < 0) {
                    val index = -find - 1
                    if (index > j)
                        count += minOf(index, nums.size) - j - 1
                }
            }
        }

        return count
    }
}

fun main(args: Array<String>) {
    println(Solution611().triangleNumber(intArrayOf(1,1,3,4)))
}