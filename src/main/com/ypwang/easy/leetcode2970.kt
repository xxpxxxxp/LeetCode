package com.ypwang.easy

class Solution10031 {
    fun incremovableSubarrayCount(nums: IntArray): Int {
        var ans = 0
        val n = nums.size
        for (i in 0 until n) {
            for (j in i until n) {
                var ok = true
                var lst = 0
                for (k in 0 until n) {
                    if (k in i..j)
                        continue

                    if (lst >= nums[k]) {
                        ok = false
                        break
                    }
                    lst = nums[k]
                }

                if (ok)
                    ans++
            }
        }

        return ans
    }
}

fun main() {
    println(Solution10031().incremovableSubarrayCount(intArrayOf(6,5,7,8)))
    println(Solution10031().incremovableSubarrayCount(intArrayOf(1,2,3,4)))
}