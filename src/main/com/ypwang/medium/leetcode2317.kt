package com.ypwang.medium

class Solution2317 {
    fun maximumXOR(nums: IntArray): Int {
        val arr = BooleanArray(31)
        for (n in nums) {
            for ((i, v) in n.toString(2).reversed().withIndex()) {
                arr[i] = arr[i] || v == '1'
            }
        }

        var rst = 0
        for ((i, v) in arr.withIndex()) {
            if (v)
                rst = rst or (1 shl i)
        }

        return rst
    }
}

fun main() {
    println(Solution2317().maximumXOR(intArrayOf(3,2,4,6)))
    println(Solution2317().maximumXOR(intArrayOf(1,2,3,9,2)))
}