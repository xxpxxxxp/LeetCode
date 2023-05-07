package com.ypwang.medium

class Solution2672 {
    fun colorTheArray(n: Int, queries: Array<IntArray>): IntArray {
        val nums = IntArray(n)
        val rst = IntArray(queries.size)
        var c = 0
        for ((i, arr) in queries.withIndex()) {
            val (index, color) = arr
            val pre = if (index > 0) nums[index - 1] else 0
            val nex = if (index < n - 1) nums[index + 1] else 0
            if (nums[index] != 0 && nums[index] == pre) c--
            if (nums[index] != 0 && nums[index] == nex) c--
            nums[index] = color
            if (nums[index] == pre) c++
            if (nums[index] == nex) c++
            rst[i] = c
        }
        return rst
    }
}