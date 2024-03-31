package com.ypwang.medium

class Solution3097 {
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        var f = 0
        var count = IntArray(32)

        var i = 0
        var j = 0
        var rst = Int.MAX_VALUE

        while (j < nums.size) {
            for ((z, b) in nums[j].toString(2).reversed().withIndex()) {
                if (b == '1')
                    count[z]++
            }
            f = f or nums[j]
            j++

            if (f >= k) {
                while (i < j && f >= k) {
                    for ((z, b) in nums[i].toString(2).reversed().withIndex()) {
                        if (b == '1') {
                            count[z]--
                            if (count[z] == 0)
                                f = f and (1 shl z).inv()
                        }
                    }
                    i++
                }
                rst = minOf(rst, j-i+1)
            }
        }

        return if (rst == Int.MAX_VALUE) -1 else rst
    }
}

fun main() {
    println(Solution3097().minimumSubarrayLength(intArrayOf(1,2,32,21), 55))
    println(Solution3097().minimumSubarrayLength(intArrayOf(1,2,3), 2))
    println(Solution3097().minimumSubarrayLength(intArrayOf(2,1,8), 10))
    println(Solution3097().minimumSubarrayLength(intArrayOf(1,2), 0))
}
