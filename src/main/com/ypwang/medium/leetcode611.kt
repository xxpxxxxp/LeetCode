package com.ypwang.medium

class Solution611 {
    fun triangleNumber(nums: IntArray): Int {
        if (nums.size < 3) return 0

        nums.sort()

        var count = 0
        for (i in 0 until nums.size - 2) {
            if (nums[i] == 0) continue
            var k = i + 2
            for (j in i+1 until nums.size - 1) {
                count += k - j - 1

                while (k < nums.size && nums[i] + nums[j] > nums[k]) {
                    count++
                    k++
                }
            }
        }

        return count
    }
}

fun main() {
    println(Solution611().triangleNumber(intArrayOf(0, 1, 0, 1)))
}