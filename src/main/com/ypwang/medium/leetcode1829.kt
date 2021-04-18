package com.ypwang.medium

class Solution1829 {
    fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
        val rst = IntArray(nums.size)

        var acc = 0
        for ((i, num) in nums.withIndex()) {
            acc = acc xor num
            rst[i] = acc.inv() and ((1 shl maximumBit) - 1)
        }

        rst.reverse()
        return rst
    }
}

fun main() {
    println(Solution1829().getMaximumXor(intArrayOf(0,1,1,3), 2))
}