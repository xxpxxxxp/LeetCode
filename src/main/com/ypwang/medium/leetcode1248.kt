package com.ypwang.medium

class Solution1248 {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        var cnt = 0
        var i = 0
        var j = 0
        var sum = 0
        while (j < nums.size) {
            while (j < nums.size && cnt != k) {
                if (nums[j] % 2 == 1) cnt++
                j++
            }
            if (cnt != k) continue
            val n = j
            while (j < nums.size && nums[j] % 2 == 0) {
                j++
            }

            val m = i
            while (nums[i] % 2 == 0) {
                i++
            }
            sum += (i-m+1) * (j-n+1)
            i++
            cnt--
        }

        return sum
    }
}

fun main() {
    println(Solution1248().numberOfSubarrays(intArrayOf(1,1,2,1,1), 3))
    println(Solution1248().numberOfSubarrays(intArrayOf(2,4,6), 1))
    println(Solution1248().numberOfSubarrays(intArrayOf(2,2,2,1,2,2,1,2,2,2), 2))
}