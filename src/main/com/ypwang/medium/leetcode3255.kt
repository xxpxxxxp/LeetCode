package com.ypwang.medium

class Solution3255 {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        var pre = -1
        var len = 0

        val rst = IntArray(nums.size - k + 1)
        for ((i, n) in nums.withIndex()) {
            if (n == pre + 1)
                len++
            else
                len = 1

            if (i+1 >= k) {
                rst[i - k + 1] =
                    if (len >= k)
                        n
                    else
                        -1
            }

            pre = n
        }

        return rst
    }
}

fun main() {
    println(Solution3255().resultsArray(intArrayOf(1,2,3,4,3,2,5), 3).toList())
}
