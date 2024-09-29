package com.ypwang.easy

class Solution3300 {
    fun minElement(nums: IntArray): Int =
        nums.map(::helper).min()!!

    private fun helper(n: Int): Int {
        var n = n
        var rst = 0
        while (n != 0) {
            rst += n % 10
            n /= 10
        }
        return rst
    }
}
