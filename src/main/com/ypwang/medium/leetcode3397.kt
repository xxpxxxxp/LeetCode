package com.ypwang.medium

class Solution3397 {
    fun maxDistinctElements(nums: IntArray, k: Int): Int {
        nums.sort()
        var pre = Int.MIN_VALUE
        var rst = 0

        for (n in nums) {
            if (pre < n - k) {
                pre = n - k
                rst++
            } else if (pre < n + k) {
                pre++
                rst++
            }
        }

        return rst
    }
}

fun main() {
    println(Solution3397().maxDistinctElements(intArrayOf(7,8,10,10,7,6,7), 1))
}