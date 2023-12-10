package com.ypwang.medium

class Solution2958 {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        var i = 0
        var j = i
        var count = mutableMapOf<Int, Int>()

        var max = 0
        while (j < nums.size) {
            val v = nums[j]
            count[v] = count.getOrDefault(v, 0) + 1
            if (count[v]!! > k) {
                while (nums[i] != v) {
                    count[nums[i]] = count[nums[i]]!! - 1
                    i++
                }
                i++
                count[v] = count[v]!! - 1
            }

            max = maxOf(max, j - i + 1)
            j++
        }

        return max
    }
}

fun main() {
    println(Solution2958().maxSubarrayLength(intArrayOf(1,2,3,1,2,3,1,2), 2))
}